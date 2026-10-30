package edu.altair.api_crm_altair.exceptions;

public class EstadoNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EstadoNotFoundException(String mensaje) 
	{
        super(mensaje);
    }
}
