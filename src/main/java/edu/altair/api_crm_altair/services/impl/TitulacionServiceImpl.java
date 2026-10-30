package edu.altair.api_crm_altair.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.api_crm_altair.dtos.TitulacionRequestDto;
import edu.altair.api_crm_altair.dtos.TitulacionResponseDto;
import edu.altair.api_crm_altair.entities.Titulacion;
import edu.altair.api_crm_altair.exceptions.CodigoAlreadyExistsException;
import edu.altair.api_crm_altair.exceptions.TitulacionNotFoundException;
import edu.altair.api_crm_altair.repositories.TitulacionRepository;
import edu.altair.api_crm_altair.services.TitulacionService;

@Service
public class TitulacionServiceImpl implements TitulacionService 
{
	private final TitulacionRepository titulacionRepository;

    // Inyección de dependencias por constructor
    public TitulacionServiceImpl(TitulacionRepository titulacionRepository) 
    {
        this.titulacionRepository = titulacionRepository;
    }
    
	@Override
	@Transactional(readOnly = true)
	public List<TitulacionResponseDto> obtenerTodos() 
	{
        return titulacionRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
	}

	@Override
	@Transactional(readOnly = true)
	public TitulacionResponseDto obtenerPorId(Long id) 
	{
        Titulacion titulacion = titulacionRepository.findById(id)
                .orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrada con el ID: " + id));
        return mapToResponseDto(titulacion);
	}

	@Override
	@Transactional(readOnly = true)
	public TitulacionResponseDto obtenerPorCodigo(int codigo) 
	{
        Titulacion titulacion = titulacionRepository.findByCodigo(codigo)
                .orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrado con el codigo: " + codigo));
        return mapToResponseDto(titulacion);
	}

	@Override
	@Transactional(readOnly = true)
	public TitulacionResponseDto obtenerPorDiminutivo(String diminutivo) 
	{
        Titulacion titulacion = titulacionRepository.findByDiminutivo(diminutivo)
                .orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrado por el diminutivo: " + diminutivo));
        return mapToResponseDto(titulacion);
	}

	@Override
	@Transactional
	public TitulacionResponseDto crear(TitulacionRequestDto dto) 
	{
		// Validación de regla de negocio: codigo único
		 if  (titulacionRepository.existsByCodigo(dto.codigo())) {
			 throw new CodigoAlreadyExistsException("Ya existe una titulacion registrada con el codigo: " + dto.codigo());
		 }
		 
       Titulacion nuevaTitulacion = new Titulacion(
               null,
		   	   dto.codigo(),
		   	   dto.diminutivo(),
               dto.horasTotales()
       );

       Titulacion guardado = titulacionRepository.save(nuevaTitulacion);
       return mapToResponseDto(guardado);
	}

	@Override
	@Transactional
	public TitulacionResponseDto actualizar(Long id, TitulacionRequestDto dto) 
	{
        Titulacion titulacionExistente = titulacionRepository.findById(id)
                .orElseThrow(() -> new TitulacionNotFoundException("Titulacion no encontrada con el ID: " + id));

        titulacionExistente.setCodigo(dto.codigo());
        titulacionExistente.setDiminutivo(dto.diminutivo());
        titulacionExistente.setHorasTotales(dto.horasTotales());

        Titulacion actualizado = titulacionRepository.save(titulacionExistente);
        return mapToResponseDto(actualizado);
	}

	@Override
	@Transactional
	public void eliminar(Long id)
	{
		if (!titulacionRepository.existsById(id)) 
		{
			throw new TitulacionNotFoundException("Imposible eliminar. Titulacion no encontrada con el ID: " + id);
		}
		
		titulacionRepository.deleteById(id);	 

	}
	
    // Método auxiliar de mapeo de Entidad a DTO
    private TitulacionResponseDto mapToResponseDto(Titulacion tit) {
        return new TitulacionResponseDto(
        		tit.getCodigo(),
                tit.getDiminutivo(),
                tit.getHorasTotales()
        );
    }

}
