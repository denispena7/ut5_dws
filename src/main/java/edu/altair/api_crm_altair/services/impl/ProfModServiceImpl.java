package edu.altair.api_crm_altair.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.api_crm_altair.dtos.requests.ProfModRequestDto;
import edu.altair.api_crm_altair.dtos.responses.DepartamentoResponseDto;
import edu.altair.api_crm_altair.dtos.responses.ModuloResponseDto;
import edu.altair.api_crm_altair.dtos.responses.ModulosProfesorResponseDto;
import edu.altair.api_crm_altair.dtos.responses.ProfesorResponseDto;
import edu.altair.api_crm_altair.dtos.responses.ProfesoresModuloResponseDto;
import edu.altair.api_crm_altair.entities.Modulo;
import edu.altair.api_crm_altair.entities.ProfMod;
import edu.altair.api_crm_altair.entities.Profesor;
import edu.altair.api_crm_altair.exceptions.EntityNotFoundException;
import edu.altair.api_crm_altair.repositories.ModuloRepository;
import edu.altair.api_crm_altair.repositories.ProfModRepository;
import edu.altair.api_crm_altair.repositories.ProfesorRepository;
import edu.altair.api_crm_altair.services.ProfModService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfModServiceImpl implements ProfModService
{
	private final ProfModRepository repositorio;
    private final ProfesorRepository profesorRepository;
    private final ModuloRepository moduloRepository;

    @Override
    @Transactional(readOnly = true)
    public ProfesoresModuloResponseDto obtenerProfesoresXModulo(Long id) {

        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Módulo no encontrado con el ID: " + id));

        List<ProfesorResponseDto> profesores = repositorio
                .findAllByModulo_IdModulo(id)
                .stream()
                .map(asignacion -> mapToProfesorResponseDto(asignacion.getProfesor()))
                .toList();

        return new ProfesoresModuloResponseDto(
                mapToModuloResponseDto(modulo),
                profesores
        );
    }

    @Override
    @Transactional(readOnly = true)
    public ModulosProfesorResponseDto obtenerModulosXProfesor(Long id) {

        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Profesor no encontrado con el ID: " + id));

        List<ModuloResponseDto> modulos = repositorio
                .findAllByProfesor_IdProfesor(id)
                .stream()
                .map(asignacion -> mapToModuloResponseDto(asignacion.getModulo()))
                .toList();

        return new ModulosProfesorResponseDto(
                mapToProfesorResponseDto(profesor),
                modulos
        );
    }

    @Override
    @Transactional
    public ProfesoresModuloResponseDto crear(ProfModRequestDto requestDto) {

        // Recuperar profesor
        Profesor profesor = profesorRepository.findById(requestDto.idProfesor())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Profesor no encontrado con el ID: " + requestDto.idProfesor()));

        // Recuperar módulo
        Modulo modulo = moduloRepository.findById(requestDto.idModulo())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Módulo no encontrado con el ID: " + requestDto.idModulo()));

        // Evitar asociaciones duplicadas
        if (repositorio.existsByProfesor_IdProfesorAndModulo_IdModulo(
                requestDto.idProfesor(), requestDto.idModulo())) {

            throw new IllegalStateException(
                    "Este profesor ya tiene asignado este módulo");
        }

        // Crear asociación
        ProfMod nuevaAsignacion = new ProfMod(
                null,
                profesor,
                modulo
        );

        repositorio.save(nuevaAsignacion);

        // Devolver el módulo y todos sus profesores
        return obtenerProfesoresXModulo(modulo.getIdModulo());
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

        if (!repositorio.existsById(id)) {
            throw new EntityNotFoundException(
                    "No se ha encontrado la asignación con ID: " + id);
        }

        repositorio.deleteById(id);
    }

    // Mapeo Profesor -> ProfesorResponseDto
    private ProfesorResponseDto mapToProfesorResponseDto(Profesor profesor) {

        DepartamentoResponseDto departamentoDto = null;

        if (profesor.getDepartamento() != null) {
            departamentoDto = new DepartamentoResponseDto(
            		profesor.getDepartamento().getIdDepartamento(),
                    profesor.getDepartamento().getCodigo(),
                    profesor.getDepartamento().getNombre(),
                    profesor.getDepartamento().getDescripcion(),
                    profesor.getDepartamento().getTelefono()
            );
        }

        return new ProfesorResponseDto(
        		profesor.getIdProfesor(),
                profesor.getNombre(),
                profesor.getApellidos(),
                profesor.getDni(),
                profesor.getEmail_centro(),
                profesor.getEmail_personal(),
                profesor.getTelefono_personal(),
                departamentoDto
        );
    }

    // Mapeo Modulo -> ModuloResponseDto
    private ModuloResponseDto mapToModuloResponseDto(Modulo modulo) {

        return new ModuloResponseDto(
        		modulo.getIdModulo(),
                modulo.getCodigo(),
                modulo.getDiminutivo(),
                modulo.getNombre(),
                modulo.getDescripcion(),
                modulo.getHorasSemanales(),
                modulo.getCreditos()
        );
    }
}
