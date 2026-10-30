package edu.altair.api_crm_altair.dtos;

public record DepartamentoRequestDto(
	    int codigo,
	    String nombre,
	    String descripcion,
	    String telefono
) {}