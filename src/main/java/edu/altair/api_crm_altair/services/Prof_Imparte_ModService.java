package edu.altair.api_crm_altair.services;

import edu.altair.api_crm_altair.dtos.ModulosProfesorResponseDto;
import edu.altair.api_crm_altair.dtos.ProfModRequestDto;
import edu.altair.api_crm_altair.dtos.ProfesoresModuloResponseDto;

public interface Prof_Imparte_ModService 
{
    ProfesoresModuloResponseDto obtenerProfesoresXModulo(Long id);
    ModulosProfesorResponseDto obtenerModulosXProfesor(Long id);
    ProfesoresModuloResponseDto crear(ProfModRequestDto requestDto);
    void eliminar(Long id);
    


}
