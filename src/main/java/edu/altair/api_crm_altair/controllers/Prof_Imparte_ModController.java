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

import edu.altair.api_crm_altair.dtos.ModulosProfesorResponseDto;
import edu.altair.api_crm_altair.dtos.ProfModRequestDto;
import edu.altair.api_crm_altair.dtos.ProfesoresModuloResponseDto;
import edu.altair.api_crm_altair.services.Prof_Imparte_ModService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/modulo_profesor")
public class Prof_Imparte_ModController 
{
	private final Prof_Imparte_ModService service;
	
    // Obtener los profesores que imparten un módulo
    @GetMapping("/modulo/{id}")
    public ResponseEntity<ProfesoresModuloResponseDto> obtenerProfesoresXModulo(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerProfesoresXModulo(id));
    }

    // Obtener los módulos que imparte un profesor
    @GetMapping("/profesor/{id}")
    public ResponseEntity<ModulosProfesorResponseDto> obtenerModulosXProfesor(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerModulosXProfesor(id));
    }

    // Crear una asignación profesor-módulo
    @PostMapping
    public ResponseEntity<ProfesoresModuloResponseDto> crear(
            @RequestBody ProfModRequestDto requestDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.crear(requestDto));
    }

    // Eliminar una asignación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
