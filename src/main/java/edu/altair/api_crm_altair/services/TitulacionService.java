package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.TitulacionRequestDto;
import edu.altair.api_crm_altair.dtos.responses.TitulacionResponseDto;

public interface TitulacionService 
{
    List<TitulacionResponseDto> obtenerTodos();
    TitulacionResponseDto obtenerPorId(Long id);
    TitulacionResponseDto obtenerPorCodigo(int codigo);
    TitulacionResponseDto obtenerPorDiminutivo(String diminutivo);
    TitulacionResponseDto crear(TitulacionRequestDto requestDto);
    TitulacionResponseDto actualizar(Long id, TitulacionRequestDto requestDto);
    void eliminar(Long id);
}
