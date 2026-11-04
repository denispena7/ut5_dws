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

import edu.altair.api_crm_altair.dtos.requests.TitulacionRequestDto;
import edu.altair.api_crm_altair.dtos.responses.TitulacionResponseDto;
import edu.altair.api_crm_altair.services.TitulacionService;
import lombok.RequiredArgsConstructor;

/**
 *  Controlador REST para la entidad Titulacion, con sus metodos para gestionar las peticiones HTTP de titulaciones
 *  @author csi26-denis
 *  @version 2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/titulacion")
public class TitulacionController 
{
	private final TitulacionService titulacionService;
    
    /**
     * Metodo para manejar la peticion HTTP GET que obtiene todas las titulaciones registradas
     * @return ResponseEntity con la lista de objetos de tipo TitulacionResponseDto y codigo HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<TitulacionResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(titulacionService.obtenerTodos()); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP GET que busca una titulacion por su identificador unico
     * @param id es el identificador de la titulacion a buscar
     * @return ResponseEntity con el objeto de tipo TitulacionResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<TitulacionResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(titulacionService.obtenerPorId(id)); // HTTP 200 OK
    }
    
    /**
     * Metodo para manejar la peticion HTTP GET que busca una titulacion por su codigo
     * @param cod es el codigo por el que buscar la titulacion
     * @return ResponseEntity con el objeto de tipo TitulacionResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/cod/{cod}")
    public ResponseEntity<TitulacionResponseDto> obtenerPorCodigo(@PathVariable int cod) {
        return ResponseEntity.ok(titulacionService.obtenerPorCodigo(cod)); // HTTP 200 OK
    }
    
    /**
     * Metodo para manejar la peticion HTTP GET que busca una titulacion por su diminutivo
     * @param diminutivo es el diminutivo por el que buscar la titulacion
     * @return ResponseEntity con el objeto de tipo TitulacionResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/dim/{diminutivo}")
    public ResponseEntity<TitulacionResponseDto> obtenerPorDiminutivo(@PathVariable String diminutivo) {
        return ResponseEntity.ok(titulacionService.obtenerPorDiminutivo(diminutivo)); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP POST que registra una nueva titulacion en el sistema
     * @param requestDto es el objeto con los datos de entrada para registrar a la titulacion
     * @return ResponseEntity con el objeto de tipo TitulacionResponseDto creado y codigo HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<TitulacionResponseDto> crear(@RequestBody TitulacionRequestDto requestDto) {
        TitulacionResponseDto creado = titulacionService.crear(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    /**
     * Metodo para manejar la peticion HTTP PUT que actualiza los datos de una titulacion existente
     * @param id es el identificador de la titulacion a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar a la titulacion
     * @return ResponseEntity con el objeto de tipo TitulacionResponseDto actualizado y codigo HTTP 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<TitulacionResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody TitulacionRequestDto requestDto) {
        TitulacionResponseDto actualizado = titulacionService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP DELETE que elimina una titulacion del sistema por su identificador unico
     * @param id es el identificador de la titulacion a eliminar
     * @return ResponseEntity con codigo HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        titulacionService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}

