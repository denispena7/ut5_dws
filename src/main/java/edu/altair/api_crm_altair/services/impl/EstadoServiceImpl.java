package edu.altair.api_crm_altair.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.api_crm_altair.dtos.requests.EstadoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.EstadoResponseDto;
import edu.altair.api_crm_altair.entities.Estado;
import edu.altair.api_crm_altair.exceptions.EntityNotFoundException;
import edu.altair.api_crm_altair.repositories.EstadoRepository;
import edu.altair.api_crm_altair.services.EstadoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstadoServiceImpl implements EstadoService 
{
	private final EstadoRepository estadoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<EstadoResponseDto> obtenerTodos() 
	{
        return estadoRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public EstadoResponseDto obtenerPorId(Long id) 
	{
        Estado modulo = estadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estado no encontrado con el ID: " + id));
        return mapToResponseDto(modulo);
	}

	@Override
	@Transactional
	public EstadoResponseDto crear(EstadoRequestDto dto) 
	{		 
       Estado nuevoEstado = new Estado(
               null,
               dto.nombre(),
               dto.descripcion()
       );

       Estado guardado = estadoRepository.save(nuevoEstado);
       return mapToResponseDto(guardado);
	}

	@Override
	@Transactional
	public EstadoResponseDto actualizar(Long id, EstadoRequestDto dto) 
	{
        Estado estadoExistente = estadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estado no encontrado con el ID: " + id));

        estadoExistente.setNombre(dto.nombre());
        estadoExistente.setDescripcion(dto.descripcion());

        Estado actualizado = estadoRepository.save(estadoExistente);
        return mapToResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id) 
	{
		if (!estadoRepository.existsById(id)) 
		{
			throw new EntityNotFoundException("Imposible eliminar. Estado no encontrado con el ID: " + id);
		}
		
		estadoRepository.deleteById(id);	
	}
	
    // Método auxiliar de mapeo de Entidad a DTO
    private EstadoResponseDto mapToResponseDto(Estado est) {
        return new EstadoResponseDto(
        		est.getNombre(),
                est.getDescripcion()
        );
    }
}