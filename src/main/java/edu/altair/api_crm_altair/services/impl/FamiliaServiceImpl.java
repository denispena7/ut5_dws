package edu.altair.api_crm_altair.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.api_crm_altair.dtos.FamiliaRequestDto;
import edu.altair.api_crm_altair.dtos.FamiliaResponseDto;
import edu.altair.api_crm_altair.entities.Familia;
import edu.altair.api_crm_altair.exceptions.FamiliaNotFoundException;
import edu.altair.api_crm_altair.repositories.FamiliaRepository;
import edu.altair.api_crm_altair.services.FamiliaService;

@Service
public class FamiliaServiceImpl implements FamiliaService 
{
	private final FamiliaRepository familiaRepository;

    // Inyección de dependencias por constructor
    public FamiliaServiceImpl(FamiliaRepository familiaRepository) 
    {
        this.familiaRepository = familiaRepository;
    }
	
	@Override
	@Transactional(readOnly = true)
	public List<FamiliaResponseDto> obtenerTodos() 
	{
        return familiaRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public FamiliaResponseDto obtenerPorId(Long id) 
	{
        Familia familia = familiaRepository.findById(id)
                .orElseThrow(() -> new FamiliaNotFoundException("Familia no encontrada con el ID: " + id));
        return mapToResponseDto(familia);
	}

	@Override
	@Transactional
	public FamiliaResponseDto crear(FamiliaRequestDto fam) 
	{		 
	      Familia nuevaFamilia = new Familia(
	              null,
	      		  fam.nombre_madre(),
	      		  fam.nombre_padre(),
	              fam.apellidos_madre(),
	              fam.apellidos_padre(),
	              fam.email_madre(),
	              fam.email_padre(),
	              fam.telefono_madre(),
	              fam.telefono_padre(),
	              fam.direccion_madre(),
	              fam.direccion_padre(),
	              fam.cp_madre(),
	              fam.cp_padre(),
	              fam.municipio_madre(),
	              fam.municipio_padre(),
	              fam.provincia_madre(),
	              fam.provincia_padre(),
	              fam.son_separados(),
	              fam.es_compartido(),
	              fam.es_madre(),
	              fam.es_padre()
	      );

	      Familia guardado = familiaRepository.save(nuevaFamilia);
	      return mapToResponseDto(guardado);
	}

	@Override
	@Transactional
	public FamiliaResponseDto actualizar(Long id, FamiliaRequestDto dto)
	{
        Familia familiaExistente = familiaRepository.findById(id)
                .orElseThrow(() -> new FamiliaNotFoundException("Familia no encontrada con el ID: " + id));

        familiaExistente.setNombre_madre(dto.nombre_madre());
		familiaExistente.setNombre_padre(dto.nombre_padre());
        familiaExistente.setApellidos_madre(dto.apellidos_madre());
        familiaExistente.setApellidos_padre(dto.apellidos_padre());
        familiaExistente.setEmail_madre(dto.email_madre());
        familiaExistente.setEmail_padre(dto.email_padre());
        familiaExistente.setTelefono_madre(dto.telefono_madre());
        familiaExistente.setTelefono_padre(dto.telefono_padre());
        familiaExistente.setDireccion_madre(dto.direccion_madre());
        familiaExistente.setDireccion_padre(dto.direccion_padre());
        familiaExistente.setCp_madre(dto.cp_madre());
        familiaExistente.setCp_padre(dto.cp_padre());
        familiaExistente.setMunicipio_madre(dto.municipio_madre());
        familiaExistente.setMunicipio_padre(dto.municipio_padre());
        familiaExistente.setProvincia_madre(dto.provincia_madre());
        familiaExistente.setProvincia_padre(dto.provincia_padre());
        familiaExistente.setSon_separados(dto.son_separados());
        familiaExistente.setEs_compartido(dto.es_compartido());
        familiaExistente.setEs_madre(dto.es_madre());
        familiaExistente.setEs_padre(dto.es_padre());

        Familia actualizado = familiaRepository.save(familiaExistente);
        return mapToResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id) 
	{
		if (!familiaRepository.existsById(id)) 
		{
			throw new FamiliaNotFoundException("Imposible eliminar. Familia no encontrada con el ID: " + id);
		}
		
		familiaRepository.deleteById(id);	
	}
	
    // Método auxiliar de mapeo de Entidad a DTO
    private FamiliaResponseDto mapToResponseDto(Familia fam) {
        return new FamiliaResponseDto(
        		fam.getNombre_madre(),
        		fam.getNombre_padre(),
                fam.getApellidos_madre(),
                fam.getApellidos_padre(),
                fam.getEmail_madre(),
                fam.getEmail_padre(),
                fam.getTelefono_madre(),
                fam.getTelefono_padre(),
                fam.getDireccion_madre(),
                fam.getDireccion_padre(),
                fam.getCp_madre(),
                fam.getCp_padre(),
                fam.getMunicipio_madre(),
                fam.getMunicipio_padre(),
                fam.getProvincia_madre(),
                fam.getProvincia_padre(),
                fam.getSon_separados(),
                fam.getEs_compartido(),
                fam.getEs_madre(),
                fam.getEs_padre()
        );
    }
}