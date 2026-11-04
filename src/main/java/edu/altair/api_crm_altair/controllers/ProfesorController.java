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

import edu.altair.api_crm_altair.dtos.requests.ProfesorRequestDto;
import edu.altair.api_crm_altair.dtos.responses.ProfesorResponseDto;
import edu.altair.api_crm_altair.services.ProfesorService;
import lombok.RequiredArgsConstructor;

/**
 *  Controlador REST para la entidad Profesor, con sus metodos para gestionar las peticiones HTTP de profesores
 *  @author csi26-denis
 *  @version 2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profesor")
public class ProfesorController
{
	private final ProfesorService profesorService;
    
    /**
     * Metodo para manejar la peticion HTTP GET que obtiene todos los profesores registrados
     * @return ResponseEntity con la lista de objetos de tipo ProfesorResponseDto y codigo HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<ProfesorResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(profesorService.obtenerTodos()); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP GET que busca un profesor por su identificador unico
     * @param id es el identificador del profesor a buscar
     * @return ResponseEntity con el objeto de tipo ProfesorResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(profesorService.obtenerPorId(id)); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP POST que registra un nuevo profesor en el sistema
     * @param dto es el objeto con los datos de entrada para registrar al profesor
     * @return ResponseEntity con el objeto de tipo ProfesorResponseDto creado y codigo HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<ProfesorResponseDto> crear(@RequestBody ProfesorRequestDto dto) {
        ProfesorResponseDto creado = profesorService.crear(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    /**
     * Metodo para manejar la peticion HTTP PUT que actualiza los datos de un profesor existente
     * @param id es el identificador del profesor a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar al profesor
     * @return ResponseEntity con el objeto de tipo ProfesorResponseDto actualizado y codigo HTTP 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProfesorResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody ProfesorRequestDto requestDto) {
        ProfesorResponseDto actualizado = profesorService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP DELETE que elimina un profesor del sistema por su identificador unico
     * @param id es el identificador del profesor a eliminar
     * @return ResponseEntity con codigo HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        profesorService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}

