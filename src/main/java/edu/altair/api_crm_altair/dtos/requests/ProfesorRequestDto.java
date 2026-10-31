package edu.altair.api_crm_altair.dtos.requests;

public record ProfesorRequestDto(
	    String nombre,
	    String apellidos,
	    String dni,
	    String email_centro,
	    String email_personal,
	    String telefono_personal,
	    int codigoDepartamento
) {}