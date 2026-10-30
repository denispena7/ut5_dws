package edu.altair.api_crm_altair.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.api_crm_altair.dtos.ProfesorRequestDto;
import edu.altair.api_crm_altair.dtos.ProfesorResponseDto;
import edu.altair.api_crm_altair.entities.Departamento;
import edu.altair.api_crm_altair.entities.Profesor;
import edu.altair.api_crm_altair.exceptions.DniAlreadyExistsException;
import edu.altair.api_crm_altair.exceptions.ProfesorNotFoundException;
import edu.altair.api_crm_altair.repositories.DepartamentoRepository;
import edu.altair.api_crm_altair.repositories.ProfesorRepository;
import edu.altair.api_crm_altair.services.ProfesorService;

@Service
public class ProfesorServiceImpl implements ProfesorService 
{
	 private final ProfesorRepository profesorRepository;
	 private final DepartamentoRepository departamentoRepository;

    // Inyección de dependencias por constructor
    public ProfesorServiceImpl(ProfesorRepository profesorRepository, DepartamentoRepository depRepository) 
    {
        this.profesorRepository = profesorRepository;
        departamentoRepository = depRepository;
    }
	
	@Override
	@Transactional(readOnly = true)
	public List<ProfesorResponseDto> obtenerTodos() 
	{
        return profesorRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public ProfesorResponseDto obtenerPorId(Long id) 
	{
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new ProfesorNotFoundException("Profesor no encontrado con el ID: " + id));
        return mapToResponseDto(profesor);
	}

	@Override
	@Transactional
	public ProfesorResponseDto crear(ProfesorRequestDto dto) 
	{
		// Validación de regla de negocio: codigo único
		 if (profesorRepository.existsByDni(dto.dni())) {
			 throw new DniAlreadyExistsException("Ya existe un profesor registrado con el dni: " + dto.dni());
		 }
	
		 Departamento dep = departamentoRepository.findByCodigo(dto.codigoDepartamento())
		            .orElseThrow(() -> new ProfesorNotFoundException("Departamento no encontrado"));
		 
	      Profesor nuevoProfesor = new Profesor(
	              null,
		       	  dto.nombre(),
	              dto.apellidos(),
	              dto.dni(),
	              dto.email_centro(),
	              dto.email_personal(),
	              dto.telefono_personal(),
	              dep
	      );

      Profesor guardado = profesorRepository.save(nuevoProfesor);
      return mapToResponseDto(guardado);
	}

	@Override
	@Transactional
	public ProfesorResponseDto actualizar(Long id, ProfesorRequestDto dto) 
	{
        Profesor profesorExistente = profesorRepository.findById(id)
                .orElseThrow(() -> new ProfesorNotFoundException("Profesor no encontrado con el ID: " + id));

        profesorExistente.setNombre(dto.nombre());
        profesorExistente.setApellidos(dto.apellidos());
        profesorExistente.setDni(dto.dni());
        profesorExistente.setEmail_centro(dto.email_centro());
        profesorExistente.setEmail_personal(dto.email_personal());
        // departamento del profesor

        Profesor actualizado = profesorRepository.save(profesorExistente);
        return mapToResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id)
	{
		if (!profesorRepository.existsById(id)) 
		{
			throw new ProfesorNotFoundException("Imposible eliminar. Profesor no encontrado con el ID: " + id);
		}
		
		profesorRepository.deleteById(id);	
	}

    // Método auxiliar de mapeo de Entidad a DTO
    private ProfesorResponseDto mapToResponseDto(Profesor profesor) {
        return new ProfesorResponseDto(
        		profesor.getNombre(),
                profesor.getApellidos(),
                profesor.getDni(),
                profesor.getEmail_centro(),
                profesor.getEmail_personal(),
                profesor.getTelefono_personal(),
                profesor.getDepartamento().getNombre()
                // departamento del profesor
        );
    }
}
