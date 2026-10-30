package edu.altair.api_crm_altair.exceptions;

public class ProfesorNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProfesorNotFoundException(String mensaje) 
	{
        super(mensaje);
    }
}