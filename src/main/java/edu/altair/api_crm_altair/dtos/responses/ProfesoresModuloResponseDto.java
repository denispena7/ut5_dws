package edu.altair.api_crm_altair.dtos.responses;

import java.util.List;

public record ProfesoresModuloResponseDto(
		ModuloResponseDto modulo,
		List<ProfesorResponseDto> profesores
) {}