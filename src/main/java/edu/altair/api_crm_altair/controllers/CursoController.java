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

import edu.altair.api_crm_altair.dtos.CursoRequestDto;
import edu.altair.api_crm_altair.dtos.CursoResponseDto;
import edu.altair.api_crm_altair.services.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController
{
	private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    
    // 1. READ ALL - GET /api/curso
    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(cursoService.obtenerTodos()); // HTTP 200 OK
    }

    // 2. READ BY ID - GET /api/curso/{id}
    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.obtenerPorId(id)); // HTTP 200 OK
    }
    
    // 3. READ BY DIMINUTIVO - GET /api/curso/{dim}
    @GetMapping("/{dim}")
    public ResponseEntity<CursoResponseDto> obtenerPorDiminutivo(@PathVariable String dim) {
        return ResponseEntity.ok(cursoService.obtenerPorDiminutivo(dim)); // HTTP 200 OK
    }

    // 4. CREATE - POST /api/curso
    @PostMapping
    public ResponseEntity<CursoResponseDto> crear(@RequestBody CursoRequestDto dto) {
        CursoResponseDto creado = cursoService.crear(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 5. UPDATE - PUT /api/curso/{id}
    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody CursoRequestDto requestDto) {
        CursoResponseDto actualizado = cursoService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 6. DELETE - DELETE /api/curso/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
