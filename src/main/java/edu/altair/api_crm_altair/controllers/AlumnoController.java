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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/alumno")
public class AlumnoController 
{
	private final AlumnoService alumnoService;
    
    // 1. READ ALL - GET /api/v1/alumno
    @GetMapping
    public ResponseEntity<List<AlumnoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(alumnoService.obtenerTodos()); // HTTP 200 OK
    }

    // 2. READ BY ID - GET /api/v1/alumno/{id}
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.obtenerPorId(id)); // HTTP 200 OK
    }

    // 3. CREATE - POST /api/v1/alumno
    @PostMapping
    public ResponseEntity<AlumnoResponseDto> crear(@RequestBody AlumnoRequestDto dto) {
        AlumnoResponseDto creado = alumnoService.crear(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    // 4. UPDATE - PUT /api/v1/alumno/{id}
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody AlumnoRequestDto requestDto) {
        AlumnoResponseDto actualizado = alumnoService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    // 5. DELETE - DELETE /api/v1/alumno/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        alumnoService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
