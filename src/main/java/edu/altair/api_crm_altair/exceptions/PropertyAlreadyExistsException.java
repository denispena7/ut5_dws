package edu.altair.api_crm_altair.exceptions;

public class PropertyAlreadyExistsException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PropertyAlreadyExistsException(String mensaje) 
	{
        super(mensaje);
    }
}
