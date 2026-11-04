package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.ModuloRequestDto;
import edu.altair.api_crm_altair.dtos.responses.ModuloResponseDto;

/**
 *  Servicio para la entidad Modulo, con sus metodos para la gestion de modulos
 *  @author csi26-denis
 *  @version 2026
 */
public interface ModuloService 
{
    /**
     * Metodo para obtener todos los modulos registrados
     * @return lista de objetos de tipo ModuloResponseDto
     */
    List<ModuloResponseDto> obtenerTodos();

    /**
     * Metodo para buscar un modulo por su identificador unico
     * @param id es el identificador del modulo a buscar
     * @return objeto de tipo ModuloResponseDto con los datos del modulo encontrado
     */
    ModuloResponseDto obtenerPorId(Long id);

    /**
     * Metodo para buscar un modulo por su codigo
     * @param codigo es el codigo por el que buscar el modulo
     * @return objeto de tipo ModuloResponseDto con los datos del modulo encontrado
     */
    ModuloResponseDto obtenerPorCodigo(int codigo);

    /**
     * Metodo para buscar un modulo por su diminutivo
     * @param diminutivo es el diminutivo por el que buscar el modulo
     * @return objeto de tipo ModuloResponseDto con los datos del modulo encontrado
     */
    ModuloResponseDto obtenerPorDiminutivo(String diminutivo);

    /**
     * Metodo para registrar un nuevo modulo en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar al modulo
     * @return objeto de tipo ModuloResponseDto con los datos del modulo creado
     */
    ModuloResponseDto crear(ModuloRequestDto requestDto);

    /**
     * Metodo para actualizar los datos de un modulo existente
     * @param id es el identificador del modulo a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar al modulo
     * @return objeto de tipo ModuloResponseDto con los datos del modulo actualizado
     */
    ModuloResponseDto actualizar(Long id, ModuloRequestDto requestDto);

    /**
     * Metodo para eliminar un modulo del sistema por su identificador unico
     * @param id es el identificador del modulo a eliminar
     */
    void eliminar(Long id);
}
