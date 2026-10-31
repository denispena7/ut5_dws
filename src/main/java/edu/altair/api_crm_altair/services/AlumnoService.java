package edu.altair.api_crm_altair.services;

import java.util.List;

import edu.altair.api_crm_altair.dtos.requests.AlumnoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.AlumnoResponseDto;

public interface AlumnoService 
{
    List<AlumnoResponseDto> obtenerTodos();
    AlumnoResponseDto obtenerPorId(Long id);
    AlumnoResponseDto crear(AlumnoRequestDto requestDto);
    AlumnoResponseDto actualizar(Long id, AlumnoRequestDto requestDto);
    void eliminar(Long id);
}
