package edu.altair.api_crm_altair.dtos.responses;

public record FamiliaResponseDto(
	    String nombre_madre,
	    String nombre_padre,
	    String apellidos_madre,
	    String apellidos_padre,
	    String email_madre,
	    String email_padre,
	    String telefono_madre,
	    String telefono_padre,
	    String direccion_madre,
	    String direccion_padre,
	    int cp_madre,
	    int cp_padre,
	    String municipio_madre,
	    String municipio_padre,
	    String provincia_madre,
	    String provincia_padre,
	    boolean son_separados,
	    boolean es_compartido,
	    boolean es_madre,
	    boolean es_padre
) {}