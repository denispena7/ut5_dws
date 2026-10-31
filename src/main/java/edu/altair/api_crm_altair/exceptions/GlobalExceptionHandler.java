package edu.altair.api_crm_altair.exceptions;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	// Manejo de Error 404 - Recurso no encontrado
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
	 
	// Manejo de Error 404 - Recurso no encontrado
//	 @ExceptionHandler(DepartamentoNotFoundException.class)
//	 public ProblemDetail manejarDepartamentoNoEncontrado(DepartamentoNotFoundException ex) {
//		 
//		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
//			 HttpStatus.NOT_FOUND,
//			 ex.getMessage()
//		 );
//		 
//		 problem.setTitle("Departamento No Encontrado");
//		 problem.setType(URI.create("https://api.crm.altair.edu/errors/not-found"));
//		 problem.setProperty("timestamp", Instant.now());
//		 return problem;
//	 }
	 
		// Manejo de Error 404 - Recurso no encontrado
//	 @ExceptionHandler(ModuloNotFoundException.class)
//	 public ProblemDetail manejarModuloNoEncontrado(ModuloNotFoundException ex) {
//		 
//		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
//			 HttpStatus.NOT_FOUND,
//			 ex.getMessage()
//		 );
//		 
//		 problem.setTitle("Modulo No Encontrado");
//		 problem.setType(URI.create("https://api.crm.altair.edu/errors/not-found"));
//		 problem.setProperty("timestamp", Instant.now());
//		 return problem;
//	 }
	 
		// Manejo de Error 404 - Recurso no encontrado
//	 @ExceptionHandler(CursoNotFoundException.class)
//	 public ProblemDetail manejarCursoNoEncontrado(CursoNotFoundException ex) {
//		 
//		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
//			 HttpStatus.NOT_FOUND,
//			 ex.getMessage()
//		 );
//		 
//		 problem.setTitle("Curso No Encontrado");
//		 problem.setType(URI.create("https://api.crm.altair.edu/errors/not-found"));
//		 problem.setProperty("timestamp", Instant.now());
//		 return problem;
//	 }
	 
		// Manejo de Error 404 - Recurso no encontrado
//	 @ExceptionHandler(EstadoNotFoundException.class)
//	 public ProblemDetail manejarEstadoNoEncontrado(EstadoNotFoundException ex) {
//		 
//		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
//			 HttpStatus.NOT_FOUND,
//			 ex.getMessage()
//		 );
//		 
//		 problem.setTitle("Estado No Encontrado");
//		 problem.setType(URI.create("https://api.crm.altair.edu/errors/not-found"));
//		 problem.setProperty("timestamp", Instant.now());
//		 return problem;
//	 }
	 
		// Manejo de Error 404 - Recurso no encontrado
//	 @ExceptionHandler(TitulacionNotFoundException.class)
//	 public ProblemDetail manejarTitulacionNoEncontrado(TitulacionNotFoundException ex) {
//		 
//		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
//			 HttpStatus.NOT_FOUND,
//			 ex.getMessage()
//		 );
//		 
//		 problem.setTitle("Titulacion No Encontrada");
//		 problem.setType(URI.create("https://api.crm.altair.edu/errors/not-found"));
//		 problem.setProperty("timestamp", Instant.now());
//		 return problem;
//	 }
	 
		// Manejo de Error 404 - Recurso no encontrado
//	 @ExceptionHandler(FamiliaNotFoundException.class)
//	 public ProblemDetail manejarFamiliaNoEncontrado(FamiliaNotFoundException ex) {
//		 
//		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
//			 HttpStatus.NOT_FOUND,
//			 ex.getMessage()
//		 );
//		 
//		 problem.setTitle("Familia No Encontrada");
//		 problem.setType(URI.create("https://api.crm.altair.edu/errors/not-found"));
//		 problem.setProperty("timestamp", Instant.now());
//		 return problem;
//	 }
	 
		// Manejo de Error 404 - Recurso no encontrado
//	 @ExceptionHandler(ProfesorNotFoundException.class)
//	 public ProblemDetail manejarFamiliaNoEncontrado(ProfesorNotFoundException ex) {
//		 
//		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
//			 HttpStatus.NOT_FOUND,
//			 ex.getMessage()
//		 );
//		 
//		 problem.setTitle("Profesor No Encontrado");
//		 problem.setType(URI.create("https://api.crm.altair.edu/errors/not-found"));
//		 problem.setProperty("timestamp", Instant.now());
//		 return problem;
//	 }
	 
	 // Manejo de Error 409: Conflicto de duplicidad de propiedad
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
	 
		// Manejo de Error 409 - Conflicto de duplicidad de codigo
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
	 
	// Manejo de Error 409 - Conflicto de duplicidad de codigo
//	 @ExceptionHandler(CodigoAlreadyExistsException.class)
//	 public ProblemDetail manejarCodigoDuplicado(CodigoAlreadyExistsException ex) 
//	 {
//		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
//			 HttpStatus.CONFLICT,
//			 ex.getMessage()
//		 );
//		 
//		 problem.setTitle("Conflicto de Datos");
//		 problem.setType(URI.create("https://api.crm.altair.edu/errors/conflict"));
//		 problem.setProperty("timestamp", Instant.now());
//		 return problem;
//	 }
	 
	// Manejo de Error 409 - Conflicto de duplicidad de diminutivo
//	 @ExceptionHandler(DiminutivoAlreadyExistsException.class)
//	 public ProblemDetail manejarDiminutivoDuplicado(DiminutivoAlreadyExistsException ex) 
//	 {
//		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
//			 HttpStatus.CONFLICT,
//			 ex.getMessage()
//		 );
//		 
//		 problem.setTitle("Conflicto de Datos");
//		 problem.setType(URI.create("https://api.crm.altair.edu/errors/conflict"));
//		 problem.setProperty("timestamp", Instant.now());
//		 return problem;
//	 }
	 
		// Manejo de Error 409 - Conflicto de duplicidad de codigo
//	 @ExceptionHandler(DniAlreadyExistsException.class)
//	 public ProblemDetail manejarCodigoDuplicado(DniAlreadyExistsException ex) 
//	 {
//		 ProblemDetail problem = ProblemDetail.forStatusAndDetail(
//			 HttpStatus.CONFLICT,
//			 ex.getMessage()
//		 );
//		 
//		 problem.setTitle("Conflicto de Datos");
//		 problem.setType(URI.create("https://api.crm.altair.edu/errors/conflict"));
//		 problem.setProperty("timestamp", Instant.now());
//		 return problem;
//	 }
}