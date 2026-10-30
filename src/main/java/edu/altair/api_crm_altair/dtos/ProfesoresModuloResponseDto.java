package edu.altair.api_crm_altair.dtos;

import java.util.List;

public record ProfesoresModuloResponseDto(
		ModuloResponseDto modulo,
		List<ProfesorResponseDto> profesores
) {}