package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.CursoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.CursoResponseDto;

/**
 *  Servicio para la entidad Curso, con sus metodos para la gestion de cursos
 *  @author csi26-denis
 *  @version 2026
 */
public interface CursoService 
{
    /**
     * Metodo para obtener todos los cursos registrados
     * @return lista de objetos de tipo CursoResponseDto
     */
    List<CursoResponseDto> obtenerTodos();

    /**
     * Metodo para buscar un curso por su identificador unico
     * @param id es el identificador del curso a buscar
     * @return objeto de tipo CursoResponseDto con los datos del curso encontrado
     */
    CursoResponseDto obtenerPorId(Long id);

    /**
     * Metodo para buscar un curso por su diminutivo
     * @param diminutivo es el diminutivo por el que buscar el curso
     * @return objeto de tipo CursoResponseDto con los datos del curso encontrado
     */
    CursoResponseDto obtenerPorDiminutivo(String diminutivo);

    /**
     * Metodo para registrar un nuevo curso en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar al curso
     * @return objeto de tipo CursoResponseDto con los datos del curso creado
     */
    CursoResponseDto crear(CursoRequestDto requestDto);

    /**
     * Metodo para actualizar los datos de un curso existente
     * @param id es el identificador del curso a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar al curso
     * @return objeto de tipo CursoResponseDto con los datos del curso actualizado
     */
    CursoResponseDto actualizar(Long id, CursoRequestDto requestDto);

    /**
     * Metodo para eliminar un curso del sistema por su identificador unico
     * @param id es el identificador del curso a eliminar
     */
    void eliminar(Long id);
}

