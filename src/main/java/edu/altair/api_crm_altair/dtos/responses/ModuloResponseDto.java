package edu.altair.api_crm_altair.dtos.responses;

public record ModuloResponseDto(
		Long id,
	    int codigo,
	    String diminutivo,
	    String nombre,
	    String descripcion,
	    int horasSemanales,
	    int creditos
) {}