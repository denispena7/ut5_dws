package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.CursoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.CursoResponseDto;

public interface CursoService 
{
    List<CursoResponseDto> obtenerTodos();
    CursoResponseDto obtenerPorId(Long id);
    CursoResponseDto obtenerPorDiminutivo(String diminutivo);
    CursoResponseDto crear(CursoRequestDto requestDto);
    CursoResponseDto actualizar(Long id, CursoRequestDto requestDto);
    void eliminar(Long id);
}
