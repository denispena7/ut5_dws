package edu.altair.api_crm_altair.exceptions;

public class CursoNotFoundException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CursoNotFoundException(String mensaje) 
	{
        super(mensaje);
    }
}