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

import edu.altair.api_crm_altair.dtos.requests.FamiliaRequestDto;
import edu.altair.api_crm_altair.dtos.responses.FamiliaResponseDto;
import edu.altair.api_crm_altair.services.FamiliaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/familia")
public class FamiliaController 
{
	private final FamiliaService familiaService;
    
    // 1. READ ALL - GET /api/v1/familia
    @GetMapping
    public ResponseEntity<List<FamiliaResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(familiaService.obtenerTodos()); // HTTP 200 OK
    }

    // 2. READ BY ID - GET /api/v1/familia/{id}
    @GetMapping("/{id}")
    public ResponseEntity<FamiliaResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(familiaService.obtenerPorId(id)); // HTTP 200 OK
    }

    // 3. CREATE - POST /api/v1/familia
    @PostMapping
    public ResponseEntity<FamiliaResponseDto> crear(@RequestBody FamiliaRequestDto dto) {
        FamiliaResponseDto creado = familiaService.crear(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 4. UPDATE - PUT /api/v1/familia/{id}
    @PutMapping("/{id}")
    public ResponseEntity<FamiliaResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody FamiliaRequestDto requestDto) {
        FamiliaResponseDto actualizado = familiaService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 5. DELETE - DELETE /api/v1/familia/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        familiaService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
