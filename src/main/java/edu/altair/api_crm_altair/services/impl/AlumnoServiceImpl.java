package edu.altair.api_crm_altair.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.api_crm_altair.dtos.requests.AlumnoRequestDto;
import edu.altair.api_crm_altair.dtos.responses.AlumnoResponseDto;
import edu.altair.api_crm_altair.dtos.responses.FamiliaResponseDto;
import edu.altair.api_crm_altair.entities.Alumno;
import edu.altair.api_crm_altair.entities.Familia;
import edu.altair.api_crm_altair.exceptions.EntityNotFoundException;
import edu.altair.api_crm_altair.exceptions.PropertyAlreadyExistsException;
import edu.altair.api_crm_altair.repositories.AlumnoRepository;
import edu.altair.api_crm_altair.repositories.FamiliaRepository;
import edu.altair.api_crm_altair.services.AlumnoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService 
{
	 private final AlumnoRepository alumnoRepository;
	 private final FamiliaRepository familiaRepository;
	 
   @Override
   @Transactional(readOnly = true)
   public List<AlumnoResponseDto> obtenerTodos() {

       return alumnoRepository.findAll()
               .stream()
               .map(this::mapToResponseDto)
               .toList();
   }

   @Override
   @Transactional(readOnly = true)
   public AlumnoResponseDto obtenerPorId(Long id) {

       Alumno alumno = alumnoRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException(
                       "Alumno no encontrado con el ID: " + id));

       return mapToResponseDto(alumno);
   }

   @Override
   @Transactional
   public AlumnoResponseDto crear(AlumnoRequestDto dto) {

       // Validación de DNI único
       if (alumnoRepository.existsByDni(dto.dni())) {
           throw new PropertyAlreadyExistsException(
                   "Ya existe un alumno registrado con el DNI: " + dto.dni());
       }

       // Recuperar la familia mediante su ID
       Familia familia = familiaRepository.findById(dto.idFamilia())
               .orElseThrow(() -> new EntityNotFoundException(
                       "Familia no encontrada"));

       Alumno nuevoAlumno = new Alumno(
               null,
               dto.nombre(),
               dto.apellidos(),
               dto.dni(),
               dto.numeroSS(),
               dto.emailPersonal(),
               dto.telefonoPersonal(),
               dto.fechaAlta(),
               dto.fechaBaja(),
               dto.emailCentro(),
               familia
       );

       Alumno guardado = alumnoRepository.save(nuevoAlumno);

       return mapToResponseDto(guardado);
   }

   @Override
   @Transactional
   public AlumnoResponseDto actualizar(Long id, AlumnoRequestDto dto) {

       Alumno alumnoExistente = alumnoRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException(
                       "Alumno no encontrado con el ID: " + id));

       // Recuperar la familia actualizada
       Familia familia = familiaRepository.findById(dto.idFamilia())
               .orElseThrow(() -> new EntityNotFoundException(
                       "Familia no encontrada"));

       alumnoExistente.setNombre(dto.nombre());
       alumnoExistente.setApellidos(dto.apellidos());
       alumnoExistente.setDni(dto.dni());
       alumnoExistente.setNumeroSS(dto.numeroSS());
       alumnoExistente.setEmailPersonal(dto.emailPersonal());
       alumnoExistente.setTelefonoPersonal(dto.telefonoPersonal());
       alumnoExistente.setFechaAlta(dto.fechaAlta());
       alumnoExistente.setFechaBaja(dto.fechaBaja());
       alumnoExistente.setEmailCentro(dto.emailCentro());
       alumnoExistente.setFamilia(familia);

       Alumno actualizado = alumnoRepository.save(alumnoExistente);

       return mapToResponseDto(actualizado);
   }

   @Override
   @Transactional
   public void eliminar(Long id) {

       if (!alumnoRepository.existsById(id)) {
           throw new EntityNotFoundException(
                   "Imposible eliminar. Alumno no encontrado con el ID: " + id);
       }

       alumnoRepository.deleteById(id);
   }

   // Método auxiliar de mapeo de Entidad a DTO
   private AlumnoResponseDto mapToResponseDto(Alumno alumno) {

       FamiliaResponseDto familiaDto = null;

       if (alumno.getFamilia() != null) {

           Familia familia = alumno.getFamilia();

           familiaDto = new FamiliaResponseDto(
        		   familia.getIdFamilia(),
                   familia.getNombre_madre(),
                   familia.getNombre_padre(),
                   familia.getApellidos_madre(),
                   familia.getApellidos_padre(),
                   familia.getEmail_madre(),
                   familia.getEmail_padre(),
                   familia.getTelefono_madre(),
                   familia.getTelefono_padre(),
                   familia.getDireccion_madre(),
                   familia.getDireccion_padre(),
                   familia.getCp_madre(),
                   familia.getCp_padre(),
                   familia.getMunicipio_madre(),
                   familia.getMunicipio_padre(),
                   familia.getProvincia_madre(),
                   familia.getProvincia_padre(),
                   familia.isSon_separados(),
                   familia.isEs_compartido(),
                   familia.isEs_madre(),
                   familia.isEs_padre()
           );
       }

       return new AlumnoResponseDto(
    		   alumno.getIdAlumno(),
               alumno.getNombre(),
               alumno.getApellidos(),
               alumno.getDni(),
               alumno.getNumeroSS(),
               alumno.getEmailPersonal(),
               alumno.getTelefonoPersonal(),
               alumno.getFechaAlta(),
               alumno.getFechaBaja(),
               alumno.getEmailCentro(),
               familiaDto
       );
   }
}