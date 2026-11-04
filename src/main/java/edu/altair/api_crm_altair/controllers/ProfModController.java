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

import edu.altair.api_crm_altair.dtos.requests.ProfModRequestDto;
import edu.altair.api_crm_altair.dtos.responses.ModulosProfesorResponseDto;
import edu.altair.api_crm_altair.dtos.responses.ProfesoresModuloResponseDto;
import edu.altair.api_crm_altair.services.ProfModService;
import lombok.RequiredArgsConstructor;

/**
 *  Controlador REST para la entidad ProfMod, con sus metodos para gestionar las peticiones HTTP de las relaciones entre profesores y modulos
 *  @author csi26-denis
 *  @version 2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/modulo-profesor")
public class ProfModController 
{
	private final ProfModService service;
	
    /**
     * Metodo para manejar la peticion HTTP GET que obtiene todos los profesores asociados a un modulo especifico por su identificador unico
     * @param id es el identificador del modulo a consultar
     * @return ResponseEntity con el objeto de tipo ProfesoresModuloResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/md/{id}")
    public ResponseEntity<ProfesoresModuloResponseDto> obtenerProfesoresXModulo(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerProfesoresXModulo(id));
    }

    /**
     * Metodo para manejar la peticion HTTP GET que obtiene todos los modulos asociados a un profesor especifico por su identificador unico
     * @param id es el identificador del profesor a consultar
     * @return ResponseEntity con el objeto de tipo ModulosProfesorResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/pf/{id}")
    public ResponseEntity<ModulosProfesorResponseDto> obtenerModulosXProfesor(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerModulosXProfesor(id));
    }

    /**
     * Metodo para manejar la peticion HTTP POST que registra una nueva relacion entre un profesor y un modulo en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar la relacion profesores-modulo
     * @return ResponseEntity con el objeto de tipo ProfesoresModuloResponseDto creado y codigo HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<ProfesoresModuloResponseDto> crear(
            @RequestBody ProfModRequestDto requestDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.crear(requestDto));
    }

    /**
     * Metodo para manejar la peticion HTTP DELETE que elimina una relacion profesores-modulo del sistema por su identificador unico
     * @param id es el identificador de la relacion a eliminar
     * @return ResponseEntity con codigo HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

