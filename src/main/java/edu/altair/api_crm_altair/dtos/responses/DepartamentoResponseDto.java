package edu.altair.api_crm_altair.dtos.responses;

public record DepartamentoResponseDto(
		Long idDepartamento,
	    int codigo,
	    String nombre,
	    String descripcion,
	    String telefono
) {}