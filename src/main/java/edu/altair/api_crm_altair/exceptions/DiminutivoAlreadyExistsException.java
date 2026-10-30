package edu.altair.api_crm_altair.exceptions;

public class DiminutivoAlreadyExistsException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DiminutivoAlreadyExistsException(String mensaje) 
	{
        super(mensaje);
    }
}