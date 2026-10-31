package edu.altair.api_crm_altair.dtos.requests;

import java.time.LocalDate;

public record AlumnoRequestDto(
		String nombre,
		String apellidos,
		String dni,
		String numeroSS,
		String emailPersonal,
		String telefonoPersonal,
		LocalDate fechaAlta,
		LocalDate fechaBaja,
		String emailCentro,
		Long idFamilia
) {}
