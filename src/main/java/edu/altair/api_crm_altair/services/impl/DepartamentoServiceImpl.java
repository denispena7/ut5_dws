package edu.altair.api_crm_altair.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.api_crm_altair.dtos.requests.DepartamentoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.DepartamentoResponseDto;
import edu.altair.api_crm_altair.entities.Departamento;
import edu.altair.api_crm_altair.exceptions.EntityNotFoundException;
import edu.altair.api_crm_altair.exceptions.PropertyAlreadyExistsException;
import edu.altair.api_crm_altair.repositories.DepartamentoRepository;
import edu.altair.api_crm_altair.services.DepartamentoService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService 
{
	 private final DepartamentoRepository departamentoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<DepartamentoResponseDto> obtenerTodos() 
	{
        return departamentoRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public DepartamentoResponseDto obtenerPorId(Long id) 
	{
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departamento no encontrado con el ID: " + id));
        return mapToResponseDto(departamento);
	}

	@Override
	@Transactional(readOnly = true)
	public DepartamentoResponseDto obtenerPorCodigo(int codigo) 
	{
        Departamento departamento = departamentoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Departamento no encontrado con el codigo: " + codigo));
        return mapToResponseDto(departamento);
	}

	@Override
	@Transactional
	public DepartamentoResponseDto crear(DepartamentoRequestDto dto) 
	{
		// Validación de regla de negocio: codigo único
		 if (departamentoRepository.existsByCodigo(dto.codigo())) {
			 throw new PropertyAlreadyExistsException("Ya existe un departamento registrado con el codigo: " + dto.codigo());
		 }
		 
        Departamento nuevoDepartamento = new Departamento(
                null,
        		dto.codigo(),
                dto.nombre(),
                dto.descripcion(),
                dto.telefono()
        );

        Departamento guardado = departamentoRepository.save(nuevoDepartamento);
        return mapToResponseDto(guardado);
	}

	@Override
	@Transactional
	public DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto dto) 
	{
        Departamento departamentoExistente = departamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departamento no encontrado con el ID: " + id));

        departamentoExistente.setNombre(dto.nombre());
        departamentoExistente.setCodigo(dto.codigo());
        departamentoExistente.setDescripcion(dto.descripcion());
        departamentoExistente.setTelefono(dto.telefono());

        Departamento actualizado = departamentoRepository.save(departamentoExistente);
        return mapToResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id) 
	{
		if (!departamentoRepository.existsById(id)) 
		{
			throw new EntityNotFoundException("Imposible eliminar. Departamento no encontrado con el ID: " + id);
		}
		
		departamentoRepository.deleteById(id);	 
	}

    // Método auxiliar de mapeo de Entidad a DTO
    private DepartamentoResponseDto mapToResponseDto(Departamento dep) {
        return new DepartamentoResponseDto(
        		dep.getIdDepartamento(),
        		dep.getCodigo(),
                dep.getNombre(),
                dep.getDescripcion(),
                dep.getTelefono()
        );
    }
}
