package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.EstadoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.EstadoResponseDto;

/**
 *  Servicio para la entidad Estado, con sus metodos para la gestion de estados
 *  @author csi26-denis
 *  @version 2026
 */
public interface EstadoService 
{
    /**
     * Metodo para obtener todos los estados registrados
     * @return lista de objetos de tipo EstadoResponseDto
     */
    List<EstadoResponseDto> obtenerTodos();

    /**
     * Metodo para buscar un estado por su identificador unico
     * @param id es el identificador del estado a buscar
     * @return objeto de tipo EstadoResponseDto con los datos del estado encontrado
     */
    EstadoResponseDto obtenerPorId(Long id);

    /**
     * Metodo para registrar un nuevo estado en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar al estado
     * @return objeto de tipo EstadoResponseDto con los datos del estado creado
     */
    EstadoResponseDto crear(EstadoRequestDto requestDto);

    /**
     * Metodo para actualizar los datos de un estado existente
     * @param id es el identificador del estado a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar al estado
     * @return objeto de tipo EstadoResponseDto con los datos del estado actualizado
     */
    EstadoResponseDto actualizar(Long id, EstadoRequestDto requestDto);

    /**
     * Metodo para eliminar un estado del sistema por su identificador unico
     * @param id es el identificador del estado a eliminar
     */
    void eliminar(Long id);
}

