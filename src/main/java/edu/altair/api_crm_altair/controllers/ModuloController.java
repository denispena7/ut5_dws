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

import edu.altair.api_crm_altair.dtos.requests.ModuloRequestDto;
import edu.altair.api_crm_altair.dtos.responses.ModuloResponseDto;
import edu.altair.api_crm_altair.services.ModuloService;
import lombok.RequiredArgsConstructor;

/**
 *  Controlador REST para la entidad Modulo, con sus metodos para gestionar las peticiones HTTP de modulos
 *  @author csi26-denis
 *  @version 2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/modulo")
public class ModuloController 
{
	private final ModuloService moduloService;

    /**
     * Metodo para manejar la peticion HTTP GET que obtiene todos los modulos registrados
     * @return ResponseEntity con la lista de objetos de tipo ModuloResponseDto y codigo HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<ModuloResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(moduloService.obtenerTodos()); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP GET que busca un modulo por su identificador unico
     * @param id es el identificador del modulo a buscar
     * @return ResponseEntity con el objeto de tipo ModuloResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<ModuloResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(moduloService.obtenerPorId(id)); // HTTP 200 OK
    }
    
    /**
     * Metodo para manejar la peticion HTTP GET que busca un modulo por su codigo
     * @param cod es el codigo por el que buscar el modulo
     * @return ResponseEntity con el objeto de tipo ModuloResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/cod/{cod}")
    public ResponseEntity<ModuloResponseDto> obtenerPorCodigo(@PathVariable int cod) {
        return ResponseEntity.ok(moduloService.obtenerPorCodigo(cod)); // HTTP 200 OK
    }
    
    /**
     * Metodo para manejar la peticion HTTP GET que busca un modulo por su diminutivo
     * @param diminutivo es el diminutivo por el que buscar el modulo
     * @return ResponseEntity con el objeto de tipo ModuloResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/dim/{diminutivo}")
    public ResponseEntity<ModuloResponseDto> obtenerPorDiminutivo(@PathVariable String diminutivo) {
        return ResponseEntity.ok(moduloService.obtenerPorDiminutivo(diminutivo)); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP POST que registra un nuevo modulo en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar al modulo
     * @return ResponseEntity con el objeto de tipo ModuloResponseDto creado y codigo HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<ModuloResponseDto> crear(@RequestBody ModuloRequestDto requestDto) {
        ModuloResponseDto creado = moduloService.crear(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    /**
     * Metodo para manejar la peticion HTTP PUT que actualiza los datos de un modulo existente
     * @param id es el identificador del modulo a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar al modulo
     * @return ResponseEntity con el objeto de tipo ModuloResponseDto actualizado y codigo HTTP 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<ModuloResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody ModuloRequestDto requestDto) {
        ModuloResponseDto actualizado = moduloService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP DELETE que elimina un modulo del sistema por su identificador unico
     * @param id es el identificador del modulo a eliminar
     * @return ResponseEntity con codigo HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        moduloService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
