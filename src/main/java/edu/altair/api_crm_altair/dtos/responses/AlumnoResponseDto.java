package edu.altair.api_crm_altair.dtos.responses;

import java.time.LocalDate;

public record AlumnoResponseDto(
		Long idAlumno,
		String nombre,
		String apellidos,
		String dni,
		String numeroSS,
		String emailPersonal,
		String telefonoPersonal,
		LocalDate fechaAlta,
		LocalDate fechaBaja,
		String emailCentro,
		FamiliaResponseDto familia
) {}