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

import edu.altair.api_crm_altair.dtos.ModuloRequestDto;
import edu.altair.api_crm_altair.dtos.ModuloResponseDto;
import edu.altair.api_crm_altair.services.ModuloService;

@RestController
@RequestMapping("/api/modulo")
public class ModuloController 
{
	private final ModuloService moduloService;

    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    // 1. READ ALL - GET /api/modulo
    @GetMapping
    public ResponseEntity<List<ModuloResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(moduloService.obtenerTodos()); // HTTP 200 OK
    }

    // 2. READ BY ID - GET /api/modulo/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ModuloResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(moduloService.obtenerPorId(id)); // HTTP 200 OK
    }
    
    // 3. READ BY CODIGO - GET /api/modulo/{cod}
    @GetMapping("/cod/{cod}")
    public ResponseEntity<ModuloResponseDto> obtenerPorCodigo(@PathVariable int cod) {
        return ResponseEntity.ok(moduloService.obtenerPorCodigo(cod)); // HTTP 200 OK
    }
    
    // 4. READ BY CODIGO - GET /api/modulo/{diminutivo}
    @GetMapping("/dim/{diminutivo}")
    public ResponseEntity<ModuloResponseDto> obtenerPorDiminutivo(@PathVariable String diminutivo) {
        return ResponseEntity.ok(moduloService.obtenerPorDiminutivo(diminutivo)); // HTTP 200 OK
    }

    // 5. CREATE - POST /api/modulo
    @PostMapping
    public ResponseEntity<ModuloResponseDto> crear(@RequestBody ModuloRequestDto requestDto) {
        ModuloResponseDto creado = moduloService.crear(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 6. UPDATE - PUT /api/modulo/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ModuloResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody ModuloRequestDto requestDto) {
        ModuloResponseDto actualizado = moduloService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 7. DELETE - DELETE /api/modulo/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        moduloService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}