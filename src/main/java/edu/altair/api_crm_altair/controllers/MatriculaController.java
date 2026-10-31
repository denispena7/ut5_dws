package edu.altair.api_crm_altair.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.altair.api_crm_altair.dtos.requests.MatriculaRequestDto;
import edu.altair.api_crm_altair.dtos.responses.MatAlumnoResponseDto;
import edu.altair.api_crm_altair.dtos.responses.MatriculaAlumnosResponseDto;
import edu.altair.api_crm_altair.services.MatriculaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/matricula")
public class MatriculaController 
{
	private final MatriculaService service;
	
    // Obtener una matrícula por su ID
    @GetMapping("/{id}")
    public ResponseEntity<MatriculaAlumnosResponseDto> obtenerMatricula(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerMatricula(id));
    }

    // Crear una matrícula
    @PostMapping
    public ResponseEntity<MatAlumnoResponseDto> crear(
            @RequestBody MatriculaRequestDto matricula) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.crear(matricula));
    }

    // Eliminar una matrícula
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
