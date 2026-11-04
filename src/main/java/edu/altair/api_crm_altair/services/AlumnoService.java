package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.AlumnoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.AlumnoResponseDto;

/**
 *  Servicio para la entidad Alumno, con sus metodos para la gestion de alumnos
 *  @author csi26-denis
 *  @version 2026
 */
public interface AlumnoService 
{
    /**
     * Metodo para obtener todos los alumnos registrados
     * @return lista de objetos de tipo AlumnoResponseDto
     */
    List<AlumnoResponseDto> obtenerTodos();

    /**
     * Metodo para buscar un alumno por su identificador unico
     * @param id es el identificador del alumno a buscar
     * @return objeto de tipo AlumnoResponseDto con los datos del alumno encontrado
     */
    AlumnoResponseDto obtenerPorId(Long id);

    /**
     * Metodo para registrar un nuevo alumno en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar al alumno
     * @return objeto de tipo AlumnoResponseDto con los datos del alumno creado
     */
    AlumnoResponseDto crear(AlumnoRequestDto requestDto);

    /**
     * Metodo para actualizar los datos de un alumno existente
     * @param id es el identificador del alumno a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar al alumno
     * @return objeto de tipo AlumnoResponseDto con los datos del alumno actualizado
     */
    AlumnoResponseDto actualizar(Long id, AlumnoRequestDto requestDto);

    /**
     * Metodo para eliminar un alumno del sistema por su identificador unico
     * @param id es el identificador del alumno a eliminar
     */
    void eliminar(Long id);
}

