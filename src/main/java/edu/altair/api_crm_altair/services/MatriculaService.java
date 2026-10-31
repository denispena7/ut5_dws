package edu.altair.api_crm_altair.services;

import edu.altair.api_crm_altair.dtos.requests.MatriculaRequestDto;
import edu.altair.api_crm_altair.dtos.responses.MatAlumnoResponseDto;
import edu.altair.api_crm_altair.dtos.responses.MatriculaAlumnosResponseDto;

public interface MatriculaService 
{
	MatriculaAlumnosResponseDto obtenerMatricula(Long id);
	MatAlumnoResponseDto crear(MatriculaRequestDto matricula);
	void eliminar(Long id);
}
