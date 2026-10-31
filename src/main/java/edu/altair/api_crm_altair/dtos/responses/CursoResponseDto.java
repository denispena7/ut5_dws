package edu.altair.api_crm_altair.dtos.responses;

public record CursoResponseDto(
	    String diminutivo,
	    String descripcion,
	    TitulacionResponseDto titulacion
) {}