package edu.altair.api_crm_altair.exceptions;

public class CodigoAlreadyExistsException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CodigoAlreadyExistsException(String mensaje) 
	{
        super(mensaje);
    }
}