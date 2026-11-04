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

/**
 *  Controlador REST para la entidad ModCur, con sus metodos para gestionar las peticiones HTTP de las relaciones entre modulos y cursos
 *  @author csi26-denis
 *  @version 2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/curso-modulo")
public class ModCurController 
{
	private final ModCurService service;
	
    /**
     * Metodo para manejar la peticion HTTP GET que obtiene todos los cursos asociados a un modulo especifico por su identificador unico
     * @param id es el identificador del modulo a consultar
     * @return ResponseEntity con el objeto de tipo CursosModuloResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/md/{id}")
    public ResponseEntity<CursosModuloResponseDto> obtenerCursosXModulo(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerCursosXModulo(id));
    }

    /**
     * Metodo para manejar la peticion HTTP GET que obtiene todos los modulos asociados a un curso especifico por su identificador unico
     * @param id es el identificador del curso a consultar
     * @return ResponseEntity con el objeto de tipo ModulosCursoResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/cur/{id}")
    public ResponseEntity<ModulosCursoResponseDto> obtenerModulosXCurso(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerModulosXCurso(id));
    }

    /**
     * Metodo para manejar la peticion HTTP POST que registra una nueva relacion entre un modulo y un curso en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar la relacion modulos-curso
     * @return ResponseEntity con el objeto de tipo ModulosCursoResponseDto creado y codigo HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<ModulosCursoResponseDto> crear(
            @RequestBody ModCurRequestDto requestDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.crear(requestDto));
    }

    /**
     * Metodo para manejar la peticion HTTP DELETE que elimina una relacion modulos-curso del sistema por su identificador unico
     * @param id es el identificador de la relacion a eliminar
     * @return ResponseEntity con codigo HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
