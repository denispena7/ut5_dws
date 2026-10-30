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

import edu.altair.api_crm_altair.dtos.ProfesorRequestDto;
import edu.altair.api_crm_altair.dtos.ProfesorResponseDto;
import edu.altair.api_crm_altair.services.ProfesorService;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController
{
	private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService)
    {
        this.profesorService = profesorService;
    }
    
    // 1. READ ALL - GET /api/profesor
    @GetMapping
    public ResponseEntity<List<ProfesorResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(profesorService.obtenerTodos()); // HTTP 200 OK
    }

    // 2. READ BY ID - GET /api/profesor/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(profesorService.obtenerPorId(id)); // HTTP 200 OK
    }

    // 3. CREATE - POST /api/profesor
    @PostMapping
    public ResponseEntity<ProfesorResponseDto> crear(@RequestBody ProfesorRequestDto dto) {
        ProfesorResponseDto creado = profesorService.crear(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 4. UPDATE - PUT /api/profesor/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ProfesorResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody ProfesorRequestDto requestDto) {
        ProfesorResponseDto actualizado = profesorService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 5. DELETE - DELETE /api/profesor/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        profesorService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
