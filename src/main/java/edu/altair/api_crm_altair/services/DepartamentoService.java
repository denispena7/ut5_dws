package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.DepartamentoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.DepartamentoResponseDto;

public interface DepartamentoService 
{
    List<DepartamentoResponseDto> obtenerTodos();
    DepartamentoResponseDto obtenerPorId(Long id);
    DepartamentoResponseDto obtenerPorCodigo(int codigo);
    DepartamentoResponseDto crear(DepartamentoRequestDto requestDto);
    DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto requestDto);
    void eliminar(Long id);
}
