package edu.altair.api_crm_altair.dtos.requests;

public record MatriculaRequestDto(
		Long idAlumno,
		Long idEstado,
		Long idModulo
) {}