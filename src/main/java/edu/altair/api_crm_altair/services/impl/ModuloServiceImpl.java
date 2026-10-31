package edu.altair.api_crm_altair.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.api_crm_altair.dtos.requests.ModuloRequestDto;
import edu.altair.api_crm_altair.dtos.responses.ModuloResponseDto;
import edu.altair.api_crm_altair.entities.Modulo;
import edu.altair.api_crm_altair.exceptions.EntityNotFoundException;
import edu.altair.api_crm_altair.exceptions.PropertyAlreadyExistsException;
import edu.altair.api_crm_altair.repositories.ModuloRepository;
import edu.altair.api_crm_altair.services.ModuloService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModuloServiceImpl implements ModuloService 
{
	 private final ModuloRepository moduloRepository;
	 
	@Override
	@Transactional(readOnly = true)
	public List<ModuloResponseDto> obtenerTodos() 
	{
        return moduloRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public ModuloResponseDto obtenerPorId(Long id) 
	{
        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Modulo no encontrado con el ID: " + id));
        return mapToResponseDto(modulo);
	}

	@Override
	@Transactional(readOnly = true)
	public ModuloResponseDto obtenerPorCodigo(int codigo) 
	{
        Modulo modulo = moduloRepository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Modulo no encontrado con el codigo: " + codigo));
        return mapToResponseDto(modulo);
	}
	
	@Override
	@Transactional(readOnly = true)
	public ModuloResponseDto obtenerPorDiminutivo(String diminutivo) 
	{
        Modulo modulo = moduloRepository.findByDiminutivo(diminutivo)
                .orElseThrow(() -> new EntityNotFoundException("Modulo no encontrado por el diminutivo: " + diminutivo));
        return mapToResponseDto(modulo);
	}

	@Override
	@Transactional
	public ModuloResponseDto crear(ModuloRequestDto dto) 
	{
		// Validación de regla de negocio: codigo único
		 if (moduloRepository.existsByCodigo(dto.codigo())) {
			 throw new PropertyAlreadyExistsException("Ya existe un modulo registrado con el codigo: " + dto.codigo());
		 }
		 
        Modulo nuevoModulo = new Modulo(
                null,
        		dto.codigo(),
        		dto.diminutivo(),
                dto.nombre(),
                dto.descripcion(),
                dto.horasSemanales(),
                dto.creditos()
        );

        Modulo guardado = moduloRepository.save(nuevoModulo);
        return mapToResponseDto(guardado);
	}

	@Override
	@Transactional
	public ModuloResponseDto actualizar(Long id, ModuloRequestDto dto) 
	{
        Modulo moduloExistente = moduloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Modulo no encontrado con el ID: " + id));

        moduloExistente.setCodigo(dto.codigo());
        moduloExistente.setDiminutivo(dto.diminutivo());
        moduloExistente.setNombre(dto.nombre());
        moduloExistente.setDescripcion(dto.descripcion());
        moduloExistente.setHorasSemanales(dto.horasSemanales());
        moduloExistente.setCreditos(dto.creditos());

        Modulo actualizado = moduloRepository.save(moduloExistente);
        return mapToResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id) 
	{
		if (!moduloRepository.existsById(id)) 
		{
			throw new EntityNotFoundException("Imposible eliminar. Modulo no encontrado con el ID: " + id);
		}
		
		moduloRepository.deleteById(id);	 
	}

    // Método auxiliar de mapeo de Entidad a DTO
    private ModuloResponseDto mapToResponseDto(Modulo mod) {
        return new ModuloResponseDto(
        		mod.getIdModulo(),
        		mod.getCodigo(),
        		mod.getDiminutivo(),
        		mod.getNombre(),
                mod.getDescripcion(),
                mod.getHorasSemanales(),
                mod.getCreditos()
        );
    }
}