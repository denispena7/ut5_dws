package edu.altair.api_crm_altair.exceptions;

public class ModuloNotFoundException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ModuloNotFoundException(String mensaje) 
	{
        super(mensaje);
    }
}