package edu.altair.api_crm_altair.dtos.responses;

import java.util.List;

public record ModulosProfesorResponseDto(
		ProfesorResponseDto profesor,
		List<ModuloResponseDto> modulos
) {}
