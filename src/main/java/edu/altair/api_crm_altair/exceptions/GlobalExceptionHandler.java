package edu.altair.api_crm_altair.exceptions;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *  Centralizacion de excepciones
 *  @author csi26-denis
 *  @version 2026
 */

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	/**
	 * Manejo de error 404 - Recurso no encontrado
	 * @param ex es la excepcion a tratar
	 * @return Respuesta formateada indicando el error
	 */
	 @ExceptionHandler(EntityNotFoundException.class)
	 public ProblemDetail manejarEntityNoEncontrado(EntityNotFoundException ex) {
		 
		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
			 HttpStatus.NOT_FOUND,
			 ex.getMessage()
		 );
		 
		 problem.setTitle("Entidad No Encontrada");
		 problem.setType(URI.create("https://api.crm.altair.edu/errors/not-found"));
		 problem.setProperty("timestamp", Instant.now());
		 return problem;
	 }
	 
		/**
		 * Manejo de Error 409: Conflicto de duplicidad de propiedad
		 * @param ex es la excepcion a tratar
		 * @return Respuesta formateada indicando el error
		 */
	 @ExceptionHandler(PropertyAlreadyExistsException.class)
	 public ProblemDetail manejarCodigoDuplicado(PropertyAlreadyExistsException ex) 
	 {
		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
			 HttpStatus.CONFLICT,
			 ex.getMessage()
		 );
		 
		 problem.setTitle("Conflicto de Datos");
		 problem.setType(URI.create("https://api.crm.altair.edu/errors/conflict"));
		 problem.setProperty("timestamp", Instant.now());
		 return problem;
	 }
	 
		/**
		 * Manejo de Error 409 - Conflicto de duplicidad de entidad
		 * @param ex es la excepcion a tratar
		 * @return Respuesta formateada indicando el error
		 */
		// 
	 @ExceptionHandler(EntityAlreadyExistsException.class)
	 public ProblemDetail manejarCodigoDuplicado(EntityAlreadyExistsException ex) 
	 {
		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
			 HttpStatus.CONFLICT,
			 ex.getMessage()
		 );
		 
		 problem.setTitle("Conflicto de Datos");
		 problem.setType(URI.create("https://api.crm.altair.edu/errors/conflict"));
		 problem.setProperty("timestamp", Instant.now());
		 return problem;
	 }
}