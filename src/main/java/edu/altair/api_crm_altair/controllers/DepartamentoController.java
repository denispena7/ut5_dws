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

/**
 *  Controlador REST para la entidad Departamento, con sus metodos para gestionar las peticiones HTTP de departamentos
 *  @author csi26-denis
 *  @version 2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/departamento")
public class DepartamentoController 
{
	private final DepartamentoService departamentoService;

    /**
     * Metodo para manejar la peticion HTTP GET que obtiene todos los departamentos registrados
     * @return ResponseEntity con la lista de objetos de tipo DepartamentoResponseDto y codigo HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(departamentoService.obtenerTodos()); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP GET que busca un departamento por su identificador unico
     * @param id es el identificador del departamento a buscar
     * @return ResponseEntity con el objeto de tipo DepartamentoResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(departamentoService.obtenerPorId(id)); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP GET que busca un departamento por su codigo
     * @param cod es el codigo por el que buscar el departamento
     * @return ResponseEntity con el objeto de tipo DepartamentoResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("cod/{cod}")
    public ResponseEntity<DepartamentoResponseDto> obtenerPorCodigo(@PathVariable int cod) {
        return ResponseEntity.ok(departamentoService.obtenerPorCodigo(cod)); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP POST que registra un nuevo departamento en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar al departamento
     * @return ResponseEntity con el objeto de tipo DepartamentoResponseDto creado y codigo HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<DepartamentoResponseDto> crear(@RequestBody DepartamentoRequestDto requestDto) {
        DepartamentoResponseDto creado = departamentoService.crear(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    /**
     * Metodo para manejar la peticion HTTP PUT que actualiza los datos de un departamento existente
     * @param id es el identificador del departamento a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar al departamento
     * @return ResponseEntity con el objeto de tipo DepartamentoResponseDto actualizado y codigo HTTP 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody DepartamentoRequestDto requestDto) {
        DepartamentoResponseDto actualizado = departamentoService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP DELETE que elimina un departamento del sistema por su identificador unico
     * @param id es el identificador del departamento a eliminar
     * @return ResponseEntity con codigo HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        departamentoService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
