package edu.altair.api_crm_altair.exceptions;

public class DepartamentoNotFoundException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DepartamentoNotFoundException(String mensaje) 
	{
        super(mensaje);
    }
}