package edu.altair.api_crm_altair.services;

import edu.altair.api_crm_altair.dtos.requests.MatriculaRequestDto;
import edu.altair.api_crm_altair.dtos.responses.MatAlumnoResponseDto;
import edu.altair.api_crm_altair.dtos.responses.MatriculaAlumnosResponseDto;

/**
 *  Servicio para la entidad Matricula, con sus metodos para la gestion de matriculas
 *  @author csi26-denis
 *  @version 2026
 */
public interface MatriculaService 
{
	/**
	 * Metodo para buscar una matricula y sus alumnos asociados por su identificador unico
	 * @param id es el identificador de la matricula a buscar
	 * @return objeto de tipo MatriculaAlumnosResponseDto con los datos de la matricula encontrada
	 */
	MatriculaAlumnosResponseDto obtenerMatricula(Long id);

	/**
	 * Metodo para registrar una nueva matricula en el sistema
	 * @param matricula es el objeto con los datos de entrada para registrar la matricula
	 * @return objeto de tipo MatAlumnoResponseDto con los datos de la matricula creada
	 */
	MatAlumnoResponseDto crear(MatriculaRequestDto matricula);

	/**
	 * Metodo para eliminar una matricula del sistema por su identificador unico
	 * @param id es el identificador de la matricula a eliminar
	 */
	void eliminar(Long id);
}

