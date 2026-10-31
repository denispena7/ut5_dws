package edu.altair.api_crm_altair.dtos.responses;

import java.util.List;

public record ModulosCursoResponseDto(
		CursoResponseDto curso,
		List<ModuloResponseDto> modulos
) {}
