package edu.altair.api_crm_altair.exceptions;

public class EntityAlreadyExistsException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EntityAlreadyExistsException(String mensaje) 
	{
        super(mensaje);
    }
}
