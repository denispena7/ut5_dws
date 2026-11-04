package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.ProfesorRequestDto;
import edu.altair.api_crm_altair.dtos.responses.ProfesorResponseDto;

/**
 *  Servicio para la entidad Profesor, con sus metodos para la gestion de profesores
 *  @author csi26-denis
 *  @version 2026
 */
public interface ProfesorService
{
    /**
     * Metodo para obtener todos los profesores registrados
     * @return lista de objetos de tipo ProfesorResponseDto
     */
    List<ProfesorResponseDto> obtenerTodos();

    /**
     * Metodo para buscar un profesor por su identificador unico
     * @param id es el identificador del profesor a buscar
     * @return objeto de tipo ProfesorResponseDto con los datos del profesor encontrado
     */
    ProfesorResponseDto obtenerPorId(Long id);

    /**
     * Metodo para registrar un nuevo profesor en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar al profesor
     * @return objeto de tipo ProfesorResponseDto con los datos del profesor creado
     */
    ProfesorResponseDto crear(ProfesorRequestDto requestDto);

    /**
     * Metodo para actualizar los datos de un profesor existente
     * @param id es el identificador del profesor a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar al profesor
     * @return objeto de tipo ProfesorResponseDto con los datos del profesor actualizado
     */
    ProfesorResponseDto actualizar(Long id, ProfesorRequestDto requestDto);

    /**
     * Metodo para eliminar un profesor del sistema por su identificador unico
     * @param id es el identificador del profesor a eliminar
     */
    void eliminar(Long id);
}

