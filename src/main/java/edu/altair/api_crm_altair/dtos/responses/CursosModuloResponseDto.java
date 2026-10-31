package edu.altair.api_crm_altair.dtos.responses;

import java.util.List;

public record CursosModuloResponseDto(
		ModuloResponseDto modulo,
		List<CursoResponseDto> cursos
) {}