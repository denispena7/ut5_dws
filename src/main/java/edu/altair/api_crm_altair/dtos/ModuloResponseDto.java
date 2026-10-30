package edu.altair.api_crm_altair.dtos;

public record ModuloResponseDto(
	    int codigo,
	    String diminutivo,
	    String nombre,
	    String descripcion,
	    int horasSemanales,
	    int creditos
) {}