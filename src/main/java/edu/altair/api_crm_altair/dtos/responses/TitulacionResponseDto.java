package edu.altair.api_crm_altair.dtos.responses;

public record TitulacionResponseDto(
		Long idTitulacion,
	    int codigo,
	    String diminutivo,
	    int horasTotales	
) {}