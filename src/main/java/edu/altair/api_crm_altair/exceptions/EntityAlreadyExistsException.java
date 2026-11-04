package edu.altair.api_crm_altair.exceptions;

/**
 *  Excepcion que indica que una clase ya existe
 *  @author csi26-denis
 *  @version 2026
 */
public class EntityAlreadyExistsException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Indica que una entidad ya existe, en caso de crearla con los
	 * datos de una ya existente
	 * @param mensaje es el mensaje a mostrar
	 */
	public EntityAlreadyExistsException(String mensaje){super(mensaje);}
}
