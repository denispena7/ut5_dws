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

import edu.altair.api_crm_altair.dtos.requests.ModCurRequestDto;
import edu.altair.api_crm_altair.dtos.responses.CursosModuloResponseDto;
import edu.altair.api_crm_altair.dtos.responses.ModulosCursoResponseDto;
import edu.altair.api_crm_altair.services.ModCurService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/curso-modulo")
public class ModCurController 
{
	private final ModCurService service;
	
    // Obtener los profesores que imparten un módulo
    @GetMapping("/modulo/{id}")
    public ResponseEntity<CursosModuloResponseDto> obtenerCursosXModulo(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerCursosXModulo(id));
    }

    // Obtener los módulos que pertenecientes a un curso
    @GetMapping("/curso/{id}")
    public ResponseEntity<ModulosCursoResponseDto> obtenerModulosXCurso(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerModulosXCurso(id));
    }

    // Crear una asignación módulo-curso
    @PostMapping
    public ResponseEntity<ModulosCursoResponseDto> crear(
            @RequestBody ModCurRequestDto requestDto) {

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
