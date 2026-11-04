package edu.altair.api_crm_altair.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.altair.api_crm_altair.dtos.requests.AlumnoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.AlumnoResponseDto;
import edu.altair.api_crm_altair.services.AlumnoService;
import lombok.RequiredArgsConstructor;

/**
 *  Controlador REST para la entidad Alumno, con sus metodos para gestionar las peticiones HTTP de alumnos
 *  @author csi26-denis
 *  @version 2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/alumno")
public class AlumnoController 
{
	private final AlumnoService alumnoService;
    
    /**
     * Metodo para manejar la peticion HTTP GET que obtiene todos los alumnos registrados
     * @return ResponseEntity con la lista de objetos de tipo AlumnoResponseDto y codigo HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<AlumnoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(alumnoService.obtenerTodos()); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP GET que busca un alumno por su identificador unico
     * @param id es el identificador del alumno a buscar
     * @return ResponseEntity con el objeto de tipo AlumnoResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.obtenerPorId(id)); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP POST que registra un nuevo alumno en el sistema
     * @param dto es el objeto con los datos de entrada para registrar al alumno
     * @return ResponseEntity con el objeto de tipo AlumnoResponseDto creado y codigo HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<AlumnoResponseDto> crear(@RequestBody AlumnoRequestDto dto) {
        AlumnoResponseDto creado = alumnoService.crear(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    /**
     * Metodo para manejar la peticion HTTP PUT que actualiza los datos de un alumno existente
     * @param id es el identificador del alumno a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar al alumno
     * @return ResponseEntity con el objeto de tipo AlumnoResponseDto actualizado y codigo HTTP 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody AlumnoRequestDto requestDto) {
        AlumnoResponseDto actualizado = alumnoService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP DELETE que elimina un alumno del sistema por su identificador unico
     * @param id es el identificador del alumno a eliminar
     * @return ResponseEntity con codigo HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        alumnoService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}

