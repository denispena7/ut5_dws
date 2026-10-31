package edu.altair.api_crm_altair.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.api_crm_altair.dtos.requests.MatriculaRequestDto;
import edu.altair.api_crm_altair.dtos.responses.AlumnoResponseDto;
import edu.altair.api_crm_altair.dtos.responses.EstadoResponseDto;
import edu.altair.api_crm_altair.dtos.responses.FamiliaResponseDto;
import edu.altair.api_crm_altair.dtos.responses.MatAlumnoResponseDto;
import edu.altair.api_crm_altair.dtos.responses.MatriculaAlumnosResponseDto;
import edu.altair.api_crm_altair.dtos.responses.ModuloResponseDto;
import edu.altair.api_crm_altair.entities.Alumno;
import edu.altair.api_crm_altair.entities.Estado;
import edu.altair.api_crm_altair.entities.Familia;
import edu.altair.api_crm_altair.entities.Matricula;
import edu.altair.api_crm_altair.entities.Modulo;
import edu.altair.api_crm_altair.exceptions.EntityAlreadyExistsException;
import edu.altair.api_crm_altair.exceptions.EntityNotFoundException;
import edu.altair.api_crm_altair.repositories.AlumnoRepository;
import edu.altair.api_crm_altair.repositories.EstadoRepository;
import edu.altair.api_crm_altair.repositories.MatriculaRepository;
import edu.altair.api_crm_altair.repositories.ModuloRepository;
import edu.altair.api_crm_altair.services.MatriculaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl implements MatriculaService 
{
	private final MatriculaRepository repositorio;
	private final ModuloRepository moduloRepository;
	private final AlumnoRepository alumnoRepository;
	private final EstadoRepository estadoRepository;
	
	@Override
    @Transactional(readOnly = true)
    public MatriculaAlumnosResponseDto obtenerMatricula(Long id) {

        Matricula matricula = repositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se ha encontrado la matrícula con ID: " + id));

        List<ModuloResponseDto> modulos = List.of(
                mapToModuloResponseDto(matricula.getModulo())
        );

        return new MatriculaAlumnosResponseDto(
                mapToAlumnoResponseDto(matricula.getAlumno()),
                mapToEstadoResponseDto(matricula.getEstado()),
                modulos
        );
    }

    @Override
    @Transactional
    public MatAlumnoResponseDto crear(MatriculaRequestDto matricula) {

        Alumno alumno = alumnoRepository.findById(matricula.idAlumno())
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se ha encontrado el alumno"));

        Estado estado = estadoRepository.findById(matricula.idEstado())
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se ha encontrado el estado"));

        Modulo modulo = moduloRepository.findById(matricula.idModulo())
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se ha encontrado el módulo"));

        if (repositorio.existeMatricula(
                matricula.idModulo(),
                matricula.idAlumno(),
                matricula.idEstado())) {

            throw new EntityAlreadyExistsException(
                    "Esta matrícula ya existe");
        }

        Matricula nuevaMatricula = new Matricula(
                null,
                modulo,
                alumno,
                estado
        );

        repositorio.save(nuevaMatricula);

        return new MatAlumnoResponseDto(
                mapToAlumnoResponseDto(alumno),
                mapToEstadoResponseDto(estado),
                mapToModuloResponseDto(modulo)
        );
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

        if (!repositorio.existsById(id)) {
            throw new EntityNotFoundException(
                    "No se ha encontrado la matrícula con ID: " + id);
        }

        repositorio.deleteById(id);
    }

    // Conversión de Alumno
    private AlumnoResponseDto mapToAlumnoResponseDto(Alumno alumno) {
        // Reutiliza aquí el mapeo de AlumnoServiceImpl.
        return new AlumnoResponseDto(
                alumno.getNombre(),
                alumno.getApellidos(),
                alumno.getDni(),
                alumno.getNumeroSS(),
                alumno.getEmailPersonal(),
                alumno.getTelefonoPersonal(),
                alumno.getFechaAlta(),
                alumno.getFechaBaja(),
                alumno.getEmailCentro(),
                mapToFamiliaResponseDto(alumno.getFamilia())
        );
    }

    // Conversión de Estado
    private EstadoResponseDto mapToEstadoResponseDto(Estado estado) {
        // Ajustar los campos al constructor real de EstadoResponseDto.
        return new EstadoResponseDto(
                estado.getNombre(),
                estado.getDescripcion()
        );
    }

    // Conversión de Módulo
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

    // Conversión de Familia
    private FamiliaResponseDto mapToFamiliaResponseDto(Familia familia) {
        if (familia == null) {
            return null;
        }

        return new FamiliaResponseDto(
                familia.getNombre_madre(),
                familia.getNombre_padre(),
                familia.getApellidos_madre(),
                familia.getApellidos_padre(),
                familia.getEmail_madre(),
                familia.getEmail_padre(),
                familia.getTelefono_madre(),
                familia.getTelefono_padre(),
                familia.getDireccion_madre(),
                familia.getDireccion_padre(),
                familia.getCp_madre(),
                familia.getCp_padre(),
                familia.getMunicipio_madre(),
                familia.getMunicipio_padre(),
                familia.getProvincia_madre(),
                familia.getProvincia_padre(),
                familia.isSon_separados(),
                familia.isEs_compartido(),
                familia.isEs_madre(),
                familia.isEs_padre()
        );
    }

}
