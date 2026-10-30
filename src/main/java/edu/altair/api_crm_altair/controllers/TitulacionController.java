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

import edu.altair.api_crm_altair.dtos.TitulacionRequestDto;
import edu.altair.api_crm_altair.dtos.TitulacionResponseDto;
import edu.altair.api_crm_altair.services.TitulacionService;

@RestController
@RequestMapping("/api/titulacion")
public class TitulacionController 
{
	private final TitulacionService titulacionService;

    public TitulacionController(TitulacionService titulacionService) {
        this.titulacionService = titulacionService;
    }
    
 // 1. READ ALL - GET /api/titulacion
    @GetMapping
    public ResponseEntity<List<TitulacionResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(titulacionService.obtenerTodos()); // HTTP 200 OK
    }

    // 2. READ BY ID - GET /api/titulacion/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TitulacionResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(titulacionService.obtenerPorId(id)); // HTTP 200 OK
    }
    
    // 3. READ BY CODIGO - GET /api/modulo/{cod}
    @GetMapping("/{cod}")
    public ResponseEntity<TitulacionResponseDto> obtenerPorCodigo(@PathVariable int cod) {
        return ResponseEntity.ok(titulacionService.obtenerPorCodigo(cod)); // HTTP 200 OK
    }
    
    // 4. READ BY CODIGO - GET /api/modulo/{diminutivo}
    @GetMapping("/{diminutivo}")
    public ResponseEntity<TitulacionResponseDto> obtenerPorDiminutivo(@PathVariable String diminutivo) {
        return ResponseEntity.ok(titulacionService.obtenerPorDiminutivo(diminutivo)); // HTTP 200 OK
    }

    // 5. CREATE - POST /api/modulo
    @PostMapping
    public ResponseEntity<TitulacionResponseDto> crear(@RequestBody TitulacionRequestDto requestDto) {
        TitulacionResponseDto creado = titulacionService.crear(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 6. UPDATE - PUT /api/modulo/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TitulacionResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody TitulacionRequestDto requestDto) {
        TitulacionResponseDto actualizado = titulacionService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 7. DELETE - DELETE /api/modulo/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        titulacionService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
