package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.EstadoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.EstadoResponseDto;

public interface EstadoService 
{
    List<EstadoResponseDto> obtenerTodos();
    EstadoResponseDto obtenerPorId(Long id);
    EstadoResponseDto crear(EstadoRequestDto requestDto);
    EstadoResponseDto actualizar(Long id, EstadoRequestDto requestDto);
    void eliminar(Long id);
}
