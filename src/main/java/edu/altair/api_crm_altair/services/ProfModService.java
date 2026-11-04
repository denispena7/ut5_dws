package edu.altair.api_crm_altair.services;

import edu.altair.api_crm_altair.dtos.requests.ProfModRequestDto;
import edu.altair.api_crm_altair.dtos.responses.ModulosProfesorResponseDto;
import edu.altair.api_crm_altair.dtos.responses.ProfesoresModuloResponseDto;

/**
 *  Servicio para la entidad ProfMod, con sus metodos para la gestion de las relaciones entre profesores y modulos
 *  @author csi26-denis
 *  @version 2026
 */
public interface ProfModService 
{
    /**
     * Metodo para obtener todos los profesores asociados a un modulo especifico por su identificador unico
     * @param id es el identificador del modulo a consultar
     * @return objeto de tipo ProfesoresModuloResponseDto con la lista de profesores del modulo
     */
    ProfesoresModuloResponseDto obtenerProfesoresXModulo(Long id);

    /**
     * Metodo para obtener todos los modulos asociados a un profesor especifico por su identificador unico
     * @param id es el identificador del profesor a consultar
     * @return objeto de tipo ModulosProfesorResponseDto con la lista de modulos del profesor
     */
    ModulosProfesorResponseDto obtenerModulosXProfesor(Long id);

    /**
     * Metodo para registrar una nueva relacion entre un profesor y un modulo en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar la relacion profesores-modulo
     * @return objeto de tipo ProfesoresModuloResponseDto con los datos de la relacion creada
     */
    ProfesoresModuloResponseDto crear(ProfModRequestDto requestDto);

    /**
     * Metodo para eliminar una relacion profesores-modulo del sistema por su identificador unico
     * @param id es el identificador de la relacion a eliminar
     */
    void eliminar(Long id);
}
