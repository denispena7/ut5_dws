package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.FamiliaRequestDto;
import edu.altair.api_crm_altair.dtos.responses.FamiliaResponseDto;

/**
 *  Servicio para la entidad Familia, con sus metodos para la gestion de familias
 *  @author csi26-denis
 *  @version 2026
 */
public interface FamiliaService 
{
    /**
     * Metodo para obtener todas las familias registradas
     * @return lista de objetos de tipo FamiliaResponseDto
     */
    List<FamiliaResponseDto> obtenerTodos();

    /**
     * Metodo para buscar una familia por su identificador unico
     * @param id es el identificador de la familia a buscar
     * @return objeto de tipo FamiliaResponseDto con los datos de la familia encontrada
     */
    FamiliaResponseDto obtenerPorId(Long id);

    /**
     * Metodo para registrar una nueva familia en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar a la familia
     * @return objeto de tipo FamiliaResponseDto con los datos de la familia creada
     */
    FamiliaResponseDto crear(FamiliaRequestDto requestDto);

    /**
     * Metodo para actualizar los datos de una familia existente
     * @param id es el identificador de la familia a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar a la familia
     * @return objeto de tipo FamiliaResponseDto con los datos de la familia actualizada
     */
    FamiliaResponseDto actualizar(Long id, FamiliaRequestDto requestDto);

    /**
     * Metodo para eliminar una familia del sistema por su identificador unico
     * @param id es el identificador de la familia a eliminar
     */
    void eliminar(Long id);
}

