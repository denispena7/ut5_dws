package edu.altair.api_crm_altair.exceptions;

public class EntityNotFoundException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String mensaje) 
	{
        super(mensaje);
    }
}