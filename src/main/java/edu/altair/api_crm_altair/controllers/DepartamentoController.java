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

import edu.altair.api_crm_altair.dtos.requests.DepartamentoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.DepartamentoResponseDto;
import edu.altair.api_crm_altair.services.DepartamentoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/departamento")
public class DepartamentoController 
{
	private final DepartamentoService departamentoService;

    // 1. READ ALL - GET /api/v1/departamento
    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(departamentoService.obtenerTodos()); // HTTP 200 OK
    }

    // 2. READ BY ID - GET /api/v1/departamento/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(departamentoService.obtenerPorId(id)); // HTTP 200 OK
    }
    // 3. READ BY CODIGO - GET /api/v1/departamento/cod/{cod}
    @GetMapping("cod/{cod}")
    public ResponseEntity<DepartamentoResponseDto> obtenerPorCodigo(@PathVariable int cod) {
        return ResponseEntity.ok(departamentoService.obtenerPorCodigo(cod)); // HTTP 200 OK
    }

    // 4. CREATE - POST /api/v1/departamento
    @PostMapping
    public ResponseEntity<DepartamentoResponseDto> crear(@RequestBody DepartamentoRequestDto requestDto) {
        DepartamentoResponseDto creado = departamentoService.crear(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 5. UPDATE - PUT /api/v1/departamento/{id}
    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody DepartamentoRequestDto requestDto) {
        DepartamentoResponseDto actualizado = departamentoService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 6. DELETE - DELETE /api/v1/departamento/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        departamentoService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}