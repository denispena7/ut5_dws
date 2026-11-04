package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.TitulacionRequestDto;
import edu.altair.api_crm_altair.dtos.responses.TitulacionResponseDto;

/**
 *  Servicio para la entidad Titulacion, con sus metodos para la gestion de titulaciones
 *  @author csi26-denis
 *  @version 2026
 */
public interface TitulacionService 
{
    /**
     * Metodo para obtener todas las titulaciones registradas
     * @return lista de objetos de tipo TitulacionResponseDto
     */
    List<TitulacionResponseDto> obtenerTodos();

    /**
     * Metodo para buscar una titulacion por su identificador unico
     * @param id es el identificador de la titulacion a buscar
     * @return objeto de tipo TitulacionResponseDto con los datos de la titulacion encontrada
     */
    TitulacionResponseDto obtenerPorId(Long id);

    /**
     * Metodo para buscar una titulacion por su codigo
     * @param codigo es el codigo por el que buscar la titulacion
     * @return objeto de tipo TitulacionResponseDto con los datos de la titulacion encontrada
     */
    TitulacionResponseDto obtenerPorCodigo(int codigo);

    /**
     * Metodo para buscar una titulacion por su diminutivo
     * @param diminutivo es el diminutivo por el que buscar la titulacion
     * @return objeto de tipo TitulacionResponseDto con los datos de la titulacion encontrada
     */
    TitulacionResponseDto obtenerPorDiminutivo(String diminutivo);

    /**
     * Metodo para registrar una nueva titulacion en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar a la titulacion
     * @return objeto de tipo TitulacionResponseDto con los datos de la titulacion creada
     */
    TitulacionResponseDto crear(TitulacionRequestDto requestDto);

    /**
     * Metodo para actualizar los datos de una titulacion existente
     * @param id es el identificador de la titulacion a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar a la titulacion
     * @return objeto de tipo TitulacionResponseDto con los datos de la titulacion actualizada
     */
    TitulacionResponseDto actualizar(Long id, TitulacionRequestDto requestDto);

    /**
     * Metodo para eliminar una titulacion del sistema por su identificador unico
     * @param id es el identificador de la titulacion a eliminar
     */
    void eliminar(Long id);
}

