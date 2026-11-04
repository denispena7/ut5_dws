package edu.altair.api_crm_altair.exceptions;

/**
 *  Excepcion que indica que una propiedad unica ya existe
 *  @author csi26-denis
 *  @version 2026
 */
public class PropertyAlreadyExistsException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Indica que una propiedad que deberia ser unica
	 * ya existe en otro objeto existente
	 * @param mensaje es el mensaje a mostrar
	 */
	public PropertyAlreadyExistsException(String mensaje){ super(mensaje);}
}
