package edu.altair.api_crm_altair.dtos;

import java.util.List;

public record ModulosProfesorResponseDto(
		ProfesorResponseDto profesor,
		List<ModuloResponseDto> modulos
) {}
