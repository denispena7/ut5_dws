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

import edu.altair.api_crm_altair.dtos.EstadoRequestDto;
import edu.altair.api_crm_altair.dtos.EstadoResponseDto;
import edu.altair.api_crm_altair.services.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController 
{
	private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) 
    {
        this.estadoService = estadoService;
    }
    
 // 1. READ ALL - GET /api/estado
    @GetMapping
    public ResponseEntity<List<EstadoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(estadoService.obtenerTodos()); // HTTP 200 OK
    }

    // 2. READ BY ID - GET /api/estado/{id}
    @GetMapping("/{id}")
    public ResponseEntity<EstadoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estadoService.obtenerPorId(id)); // HTTP 200 OK
    }

    // 3. CREATE - POST /api/estado
    @PostMapping
    public ResponseEntity<EstadoResponseDto> crear(@RequestBody EstadoRequestDto dto) {
        EstadoResponseDto creado = estadoService.crear(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 4. UPDATE - PUT /api/estado/{id}
    @PutMapping("/{id}")
    public ResponseEntity<EstadoResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody EstadoRequestDto requestDto) {
        EstadoResponseDto actualizado = estadoService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 5. DELETE - DELETE /api/estado/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estadoService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
