package edu.altair.api_crm_altair.dtos.responses;

public record CursoResponseDto(
		Long idCurso,
	    String diminutivo,
	    String descripcion,
	    TitulacionResponseDto titulacion
) {}