package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.ModuloRequestDto;
import edu.altair.api_crm_altair.dtos.responses.ModuloResponseDto;

public interface ModuloService 
{
    List<ModuloResponseDto> obtenerTodos();
    ModuloResponseDto obtenerPorId(Long id);
    ModuloResponseDto obtenerPorCodigo(int codigo);
    ModuloResponseDto obtenerPorDiminutivo(String diminutivo);
    ModuloResponseDto crear(ModuloRequestDto requestDto);
    ModuloResponseDto actualizar(Long id, ModuloRequestDto requestDto);
    void eliminar(Long id);
}
