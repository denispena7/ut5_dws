package edu.altair.api_crm_altair.dtos;

public record ProfesorResponseDto(
	    String nombre,
	    String apellidos,
	    String dni,
	    String email_centro,
	    String email_personal,
	    String telefono_personal,
	    String departamento
) {}
