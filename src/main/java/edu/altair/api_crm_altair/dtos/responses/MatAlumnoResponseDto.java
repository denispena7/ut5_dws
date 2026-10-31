package edu.altair.api_crm_altair.dtos.responses;

public record MatAlumnoResponseDto(
		AlumnoResponseDto alumno,
		EstadoResponseDto estado,
		ModuloResponseDto modulo
) {}
