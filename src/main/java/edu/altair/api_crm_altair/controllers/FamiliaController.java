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

import edu.altair.api_crm_altair.dtos.requests.FamiliaRequestDto;
import edu.altair.api_crm_altair.dtos.responses.FamiliaResponseDto;
import edu.altair.api_crm_altair.services.FamiliaService;
import lombok.RequiredArgsConstructor;

/**
 *  Controlador REST para la entidad Familia, con sus metodos para gestionar las peticiones HTTP de familias
 *  @author csi26-denis
 *  @version 2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/familia")
public class FamiliaController 
{
	private final FamiliaService familiaService;
    
    /**
     * Metodo para manejar la peticion HTTP GET que obtiene todas las familias registradas
     * @return ResponseEntity con la lista de objetos de tipo FamiliaResponseDto y codigo HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<FamiliaResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(familiaService.obtenerTodos()); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP GET que busca una familia por su identificador unico
     * @param id es el identificador de la familia a buscar
     * @return ResponseEntity con el objeto de tipo FamiliaResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<FamiliaResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(familiaService.obtenerPorId(id)); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP POST que registra una nueva familia en el sistema
     * @param dto es el objeto con los datos de entrada para registrar a la familia
     * @return ResponseEntity con el objeto de tipo FamiliaResponseDto creado y codigo HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<FamiliaResponseDto> crear(@RequestBody FamiliaRequestDto dto) {
        FamiliaResponseDto creado = familiaService.crear(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    /**
     * Metodo para manejar la peticion HTTP PUT que actualiza los datos de una familia existente
     * @param id es el identificador de la familia a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar a la familia
     * @return ResponseEntity con el objeto de tipo FamiliaResponseDto actualizado y codigo HTTP 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<FamiliaResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody FamiliaRequestDto requestDto) {
        FamiliaResponseDto actualizado = familiaService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP DELETE que elimina una familia del sistema por su identificador unico
     * @param id es el identificador de la familia a eliminar
     * @return ResponseEntity con codigo HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        familiaService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
