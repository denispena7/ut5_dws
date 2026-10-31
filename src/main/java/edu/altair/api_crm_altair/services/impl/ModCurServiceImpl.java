package edu.altair.api_crm_altair.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.api_crm_altair.dtos.requests.ModCurRequestDto;
import edu.altair.api_crm_altair.dtos.responses.CursoResponseDto;
import edu.altair.api_crm_altair.dtos.responses.CursosModuloResponseDto;
import edu.altair.api_crm_altair.dtos.responses.ModuloResponseDto;
import edu.altair.api_crm_altair.dtos.responses.ModulosCursoResponseDto;
import edu.altair.api_crm_altair.dtos.responses.TitulacionResponseDto;
import edu.altair.api_crm_altair.entities.Curso;
import edu.altair.api_crm_altair.entities.ModCur;
import edu.altair.api_crm_altair.entities.Modulo;
import edu.altair.api_crm_altair.exceptions.EntityNotFoundException;
import edu.altair.api_crm_altair.repositories.CursoRepository;
import edu.altair.api_crm_altair.repositories.ModCurRepository;
import edu.altair.api_crm_altair.repositories.ModuloRepository;
import edu.altair.api_crm_altair.services.ModCurService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModCurServiceImpl implements ModCurService
{
	private final ModCurRepository repositorio;
	private final CursoRepository cursoRepository;
	private final ModuloRepository moduloRepository;
	
	@Override
    @Transactional(readOnly = true)
    public CursosModuloResponseDto obtenerCursosXModulo(Long id) {

        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se ha encontrado el módulo con ID: " + id));

        List<CursoResponseDto> cursos = repositorio
                .findAllByModulo_IdModulo(id)
                .stream()
                .map(asignacion -> mapToCursoResponseDto(asignacion.getCurso()))
                .toList();

        return new CursosModuloResponseDto(
                mapToModuloResponseDto(modulo),
                cursos
        );
    }

    @Override
    @Transactional(readOnly = true)
    public ModulosCursoResponseDto obtenerModulosXCurso(Long id) {

        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se ha encontrado el curso con ID: " + id));

        List<ModuloResponseDto> modulos = repositorio
                .findAllByCurso_IdCurso(id)
                .stream()
                .map(asignacion -> mapToModuloResponseDto(asignacion.getModulo()))
                .toList();

        return new ModulosCursoResponseDto(
                mapToCursoResponseDto(curso),
                modulos
        );
    }

    @Override
    @Transactional
    public ModulosCursoResponseDto crear(ModCurRequestDto requestDto) {

        Curso curso = cursoRepository.findById(requestDto.idCurso())
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se ha encontrado el curso"));

        Modulo modulo = moduloRepository.findById(requestDto.idModulo())
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se ha encontrado el módulo"));

        if (repositorio.existsByCurso_IdCursoAndModulo_IdModulo(
                curso.getIdCurso(), modulo.getIdModulo())) {
            throw new IllegalStateException(
                    "Este módulo ya está asignado a este curso");
        }

        ModCur nuevaAsignacion = new ModCur(
                null,
                modulo,
                curso
        );

        repositorio.save(nuevaAsignacion);

        return obtenerModulosXCurso(curso.getIdCurso());
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

    // Mapeo de Curso a CursoResponseDto
    private CursoResponseDto mapToCursoResponseDto(Curso curso) {
        return new CursoResponseDto(
                curso.getDiminutivo(),
                curso.getDescripcion(),
                
                new TitulacionResponseDto(
                		curso.getTitulacion().getCodigo(),
                		curso.getTitulacion().getDiminutivo(),
                		curso.getTitulacion().getHorasTotales()
                )
        );
    }

    // Mapeo de Modulo a ModuloResponseDto
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
