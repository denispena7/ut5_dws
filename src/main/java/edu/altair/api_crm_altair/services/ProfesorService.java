package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.ProfesorRequestDto;
import edu.altair.api_crm_altair.dtos.responses.ProfesorResponseDto;

public interface ProfesorService
{
    List<ProfesorResponseDto> obtenerTodos();
    ProfesorResponseDto obtenerPorId(Long id);
    ProfesorResponseDto crear(ProfesorRequestDto requestDto);
    ProfesorResponseDto actualizar(Long id, ProfesorRequestDto requestDto);
    void eliminar(Long id);
}
