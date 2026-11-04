package edu.altair.api_crm_altair.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.altair.api_crm_altair.dtos.requests.MatriculaRequestDto;
import edu.altair.api_crm_altair.dtos.responses.MatAlumnoResponseDto;
import edu.altair.api_crm_altair.dtos.responses.MatriculaAlumnosResponseDto;
import edu.altair.api_crm_altair.services.MatriculaService;
import lombok.RequiredArgsConstructor;

/**
 *  Controlador REST para la entidad Matricula, con sus metodos para gestionar las peticiones HTTP de matriculas
 *  @author csi26-denis
 *  @version 2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/matricula")
public class MatriculaController 
{
	private final MatriculaService service;
	
    /**
     * Metodo para manejar la peticion HTTP GET que busca una matricula y sus alumnos asociados por su identificador unico
     * @param id es el identificador de la matricula a buscar
     * @return ResponseEntity con el objeto de tipo MatriculaAlumnosResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<MatriculaAlumnosResponseDto> obtenerMatricula(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerMatricula(id));
    }

    /**
     * Metodo para manejar la peticion HTTP POST que registra una nueva matricula en el sistema
     * @param matricula es el objeto con los datos de entrada para registrar la matricula
     * @return ResponseEntity con el objeto de tipo MatAlumnoResponseDto creado y codigo HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<MatAlumnoResponseDto> crear(
            @RequestBody MatriculaRequestDto matricula) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.crear(matricula));
    }

    /**
     * Metodo para manejar la peticion HTTP DELETE que elimina una matricula del sistema por su identificador unico
     * @param id es el identificador de la matricula a eliminar
     * @return ResponseEntity con codigo HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
