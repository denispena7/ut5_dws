package edu.altair.api_crm_altair.dtos.responses;

public record ProfesorResponseDto(
		Long id,
	    String nombre,
	    String apellidos,
	    String dni,
	    String email_centro,
	    String email_personal,
	    String telefono_personal,
	    DepartamentoResponseDto departamento
) {}
