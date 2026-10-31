package edu.altair.api_crm_altair.dtos.responses;

import java.util.List;

import edu.altair.api_crm_altair.dtos.CursoResponseDto;
import edu.altair.api_crm_altair.dtos.ModuloResponseDto;

public record ModulosCursoResponseDto(
		CursoResponseDto curso,
		List<ModuloResponseDto> modulos
) {}
