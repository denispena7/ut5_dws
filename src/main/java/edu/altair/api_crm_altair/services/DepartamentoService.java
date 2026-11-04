package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.DepartamentoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.DepartamentoResponseDto;

/**
 *  Servicio para la entidad Departamento, con sus metodos para la gestion de departamentos
 *  @author csi26-denis
 *  @version 2026
 */
public interface DepartamentoService 
{
    /**
     * Metodo para obtener todos los departamentos registrados
     * @return lista de objetos de tipo DepartamentoResponseDto
     */
    List<DepartamentoResponseDto> obtenerTodos();

    /**
     * Metodo para buscar un departamento por su identificador unico
     * @param id es el identificador del departamento a buscar
     * @return objeto de tipo DepartamentoResponseDto con los datos del departamento encontrado
     */
    DepartamentoResponseDto obtenerPorId(Long id);

    /**
     * Metodo para buscar un departamento por su codigo
     * @param codigo es el codigo por el que buscar el departamento
     * @return objeto de tipo DepartamentoResponseDto con los datos del departamento encontrado
     */
    DepartamentoResponseDto obtenerPorCodigo(int codigo);

    /**
     * Metodo para registrar un nuevo departamento en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar al departamento
     * @return objeto de tipo DepartamentoResponseDto con los datos del departamento creado
     */
    DepartamentoResponseDto crear(DepartamentoRequestDto requestDto);

    /**
     * Metodo para actualizar los datos de un departamento existente
     * @param id es el identificador del departamento a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar al departamento
     * @return objeto de tipo DepartamentoResponseDto con los datos del departamento actualizado
     */
    DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto requestDto);

    /**
     * Metodo para eliminar un departamento del sistema por su identificador unico
     * @param id es el identificador del departamento a eliminar
     */
    void eliminar(Long id);
}

