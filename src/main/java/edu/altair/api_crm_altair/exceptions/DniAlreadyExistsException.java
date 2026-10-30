package edu.altair.api_crm_altair.exceptions;

public class DniAlreadyExistsException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DniAlreadyExistsException(String mensaje) 
	{
        super(mensaje);
    }
}
