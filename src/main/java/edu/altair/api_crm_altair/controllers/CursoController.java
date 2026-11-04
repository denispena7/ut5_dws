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

import edu.altair.api_crm_altair.dtos.requests.CursoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.CursoResponseDto;
import edu.altair.api_crm_altair.services.CursoService;
import lombok.RequiredArgsConstructor;

/**
 *  Controlador REST para la entidad Curso, con sus metodos para gestionar las peticiones HTTP de cursos
 *  @author csi26-denis
 *  @version 2026
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/curso")
public class CursoController
{
	private final CursoService cursoService;
	
    /**
     * Metodo para manejar la peticion HTTP GET que obtiene todos los cursos registrados
     * @return ResponseEntity con la lista de objetos de tipo CursoResponseDto y codigo HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> obtenerTodos() {
        return ResponseEntity.ok(cursoService.obtenerTodos()); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP GET que busca un curso por su identificador unico
     * @param id es el identificador del curso a buscar
     * @return ResponseEntity con el objeto de tipo CursoResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.obtenerPorId(id)); // HTTP 200 OK
    }
    
    /**
     * Metodo para manejar la peticion HTTP GET que busca un curso por su diminutivo
     * @param dim es el diminutivo por el que buscar el curso
     * @return ResponseEntity con el objeto de tipo CursoResponseDto y codigo HTTP 200 OK
     */
    @GetMapping("/dim/{dim}")
    public ResponseEntity<CursoResponseDto> obtenerPorDiminutivo(@PathVariable String dim) {
        return ResponseEntity.ok(cursoService.obtenerPorDiminutivo(dim)); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP POST que registra un nuevo curso en el sistema
     * @param dto es el objeto con los datos de entrada para registrar al curso
     * @return ResponseEntity con el objeto de tipo CursoResponseDto creado y codigo HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<CursoResponseDto> crear(@RequestBody CursoRequestDto dto) {
        CursoResponseDto creado = cursoService.crear(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) // HTTP 201 Created
                .body(creado);
    }

    /**
     * Metodo para manejar la peticion HTTP PUT que actualiza los datos de un curso existente
     * @param id es el identificador del curso a actualizar
     * @param requestDto es el objeto con los nuevos datos para modificar al curso
     * @return ResponseEntity con el objeto de tipo CursoResponseDto actualizado y codigo HTTP 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody CursoRequestDto requestDto) {
        CursoResponseDto actualizado = cursoService.actualizar(id, requestDto);
        return ResponseEntity.ok(actualizado); // HTTP 200 OK
    }

    /**
     * Metodo para manejar la peticion HTTP DELETE que elimina un curso del sistema por su identificador unico
     * @param id es el identificador del curso a eliminar
     * @return ResponseEntity con codigo HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}

