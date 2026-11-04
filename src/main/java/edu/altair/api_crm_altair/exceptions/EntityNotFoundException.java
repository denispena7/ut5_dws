package edu.altair.api_crm_altair.exceptions;

/**
 *  Excepcion que indica que una clase no pudo ser encontrada
 *  @author csi26-denis
 *  @version 2026
 */
public class EntityNotFoundException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Indica que una entidad no ha sido encontrada
	 * @param mensaje es el mensaje a mostrar
	 */
	public EntityNotFoundException(String mensaje){super(mensaje);}
}