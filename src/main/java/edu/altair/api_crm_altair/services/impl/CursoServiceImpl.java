package edu.altair.api_crm_altair.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.api_crm_altair.dtos.CursoRequestDto;
import edu.altair.api_crm_altair.dtos.CursoResponseDto;
import edu.altair.api_crm_altair.entities.Curso;
import edu.altair.api_crm_altair.exceptions.CursoNotFoundException;
import edu.altair.api_crm_altair.exceptions.DiminutivoAlreadyExistsException;
import edu.altair.api_crm_altair.repositories.CursoRepository;
import edu.altair.api_crm_altair.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService 
{
	 private final CursoRepository cursoRepository;

    // Inyección de dependencias por constructor
    public CursoServiceImpl(CursoRepository cursoRepository) 
    {
        this.cursoRepository = cursoRepository;
    }
	
	@Override
	@Transactional(readOnly = true)
	public List<CursoResponseDto> obtenerTodos() 
	{
        return cursoRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public CursoResponseDto obtenerPorId(Long id) 
	{
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new CursoNotFoundException("Curso no encontrado con el ID: " + id));
        return mapToResponseDto(curso);
	}

	@Override
	@Transactional(readOnly = true)
	public CursoResponseDto obtenerPorDiminutivo(String diminutivo)
	{
        Curso curso = cursoRepository.findByDiminutivo(diminutivo)
                .orElseThrow(() -> new CursoNotFoundException("Curso no encontrado por el diminutivo: " + diminutivo));
        return mapToResponseDto(curso);
	}

	@Override
	@Transactional
	public CursoResponseDto crear(CursoRequestDto dto) 
	{
		// Validación de regla de negocio: codigo único
		 if (cursoRepository.existsByDiminutivo(dto.diminutivo())) {
			 throw new DiminutivoAlreadyExistsException("Ya existe un curso registrado con el diminutivo: " + dto.diminutivo());
		 }
		 
       Curso nuevoCurso = new Curso(
               null,
	       	   dto.diminutivo(),
               dto.descripcion()
       );

       Curso guardado = cursoRepository.save(nuevoCurso);
       return mapToResponseDto(guardado);
	}

	@Override
	@Transactional
	public CursoResponseDto actualizar(Long id, CursoRequestDto dto) 
	{
        Curso cursoExistente = cursoRepository.findById(id)
                .orElseThrow(() -> new CursoNotFoundException("Curso no encontrado con el ID: " + id));

        cursoExistente.setDiminutivo(dto.diminutivo());
        cursoExistente.setDescripcion(dto.descripcion());

        Curso actualizado = cursoRepository.save(cursoExistente);
        return mapToResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id) 
	{
		if (!cursoRepository.existsById(id)) 
		{
			throw new CursoNotFoundException("Imposible eliminar. Curso no encontrado con el ID: " + id);
		}
		
		cursoRepository.deleteById(id);	
	}
	
    // Método auxiliar de mapeo de Entidad a DTO
    private CursoResponseDto mapToResponseDto(Curso curso) {
        return new CursoResponseDto(
        		curso.getDiminutivo(),
                curso.getDescripcion()
        );
    }
}