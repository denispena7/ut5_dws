package edu.altair.api_crm_altair.exceptions;

public class FamiliaNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FamiliaNotFoundException(String mensaje) 
	{
        super(mensaje);
    }
}
