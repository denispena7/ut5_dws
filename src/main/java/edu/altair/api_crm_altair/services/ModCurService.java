package edu.altair.api_crm_altair.services;

import edu.altair.api_crm_altair.dtos.requests.ModCurRequestDto;
import edu.altair.api_crm_altair.dtos.responses.CursosModuloResponseDto;
import edu.altair.api_crm_altair.dtos.responses.ModulosCursoResponseDto;

/**
 *  Servicio para la entidad ModCur, con sus metodos para la gestion de las relaciones entre modulos y cursos
 *  @author csi26-denis
 *  @version 2026
 */
public interface ModCurService 
{
    /**
     * Metodo para obtener todos los cursos asociados a un modulo especifico por su identificador unico
     * @param id es el identificador del modulo a consultar
     * @return objeto de tipo CursosModuloResponseDto con la lista de cursos del modulo
     */
    CursosModuloResponseDto obtenerCursosXModulo(Long id);

    /**
     * Metodo para obtener todos los modulos asociados a un curso especifico por su identificador unico
     * @param id es el identificador del curso a consultar
     * @return objeto de tipo ModulosCursoResponseDto con la lista de modulos del curso
     */
    ModulosCursoResponseDto obtenerModulosXCurso(Long id);

    /**
     * Metodo para registrar una nueva relacion entre un modulo y un curso en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar la relacion modulos-curso
     * @return objeto de tipo ModulosCursoResponseDto con los datos de la relacion creada
     */
    ModulosCursoResponseDto crear(ModCurRequestDto requestDto);

    /**
     * Metodo para eliminar una relacion modulos-curso del sistema por su identificador unico
     * @param id es el identificador de la relacion a eliminar
     */
    void eliminar(Long id);
}
