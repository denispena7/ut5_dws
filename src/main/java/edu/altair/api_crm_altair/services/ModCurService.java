package edu.altair.api_crm_altair.services;

import edu.altair.api_crm_altair.dtos.requests.ModCurRequestDto;
import edu.altair.api_crm_altair.dtos.responses.CursosModuloResponseDto;
import edu.altair.api_crm_altair.dtos.responses.ModulosCursoResponseDto;

public interface ModCurService 
{
    CursosModuloResponseDto obtenerCursosXModulo(Long id);
    ModulosCursoResponseDto obtenerModulosXCurso(Long id);
    ModulosCursoResponseDto crear(ModCurRequestDto requestDto);
    void eliminar(Long id);
}