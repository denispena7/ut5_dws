package edu.altair.api_crm_altair.dtos.responses;

import java.util.List;

public record MatriculaAlumnosResponseDto(
		AlumnoResponseDto alumno,
		EstadoResponseDto estado,
		List<ModuloResponseDto> modulos
) {}