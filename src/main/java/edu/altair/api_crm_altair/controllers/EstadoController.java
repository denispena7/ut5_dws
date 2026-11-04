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

import edu.altair.api_crm_altair.dtos.requests.EstadoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.EstadoResponseDto;
import edu.altair.api_crm_altair.services.EstadoService;
import lombok.RequiredArgsConstructor;

/**
 *  Controlador REST para la entidad Estado, con sus metodos para gestionar las peticiones HTTP de estados
 *  @author csi26-denis
 *  @version 2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/estado")
public class EstadoController 
{
	private final EstadoService estadoService;
    
    /**
     * Metodo para manejar la peticion HTTP GET que obtiene todos los estados registrados
     * @return ResponseEntity con la lista de objetos de tipo EstadoResponseDto y codigo HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<EstadoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(estadoService.obtenerTodos()); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP GET que busca un estado por su identificador unico
     * @param id es el identificador del estado a buscar
     * @return ResponseEntity con el objeto de tipo EstadoResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<EstadoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estadoService.obtenerPorId(id)); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP POST que registra un nuevo estado en el sistema
     * @param dto es el objeto con los datos de entrada para registrar al estado
     * @return ResponseEntity con el objeto de tipo EstadoResponseDto creado y codigo HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<EstadoResponseDto> crear(@RequestBody EstadoRequestDto dto) {
        EstadoResponseDto creado = estadoService.crear(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    /**
     * Metodo para manejar la peticion HTTP PUT que actualiza los datos de un estado existente
     * @param id es el identificador del estado a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar al estado
     * @return ResponseEntity con el objeto de tipo EstadoResponseDto actualizado y codigo HTTP 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<EstadoResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody EstadoRequestDto requestDto) {
        EstadoResponseDto actualizado = estadoService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP DELETE que elimina un estado del sistema por su identificador unico
     * @param id es el identificador del estado a eliminar
     * @return ResponseEntity con codigo HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estadoService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}

