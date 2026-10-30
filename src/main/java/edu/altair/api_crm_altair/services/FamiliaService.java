package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.FamiliaRequestDto;
import edu.altair.api_crm_altair.dtos.FamiliaResponseDto;

public interface FamiliaService 
{
    List<FamiliaResponseDto> obtenerTodos();
    FamiliaResponseDto obtenerPorId(Long id);
    FamiliaResponseDto crear(FamiliaRequestDto requestDto);
    FamiliaResponseDto actualizar(Long id, FamiliaRequestDto requestDto);
    void eliminar(Long id);
}
