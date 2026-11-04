package edu.altair.api_crm_altair.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Alumno;

/**
 *  Repositorio para la entidad Alumno, con sus metodos heredados para la entidad
 *  @author csi26-denis
 *  @version 2026
 */

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> 
{
	/**
	 * Metodo derivado para consultar si ya existe un dni registrado para cada alumno
	 * @param dni es el dni del alumno
	 * @return boolean si el el alumno existe o no
	 */
	 boolean existsByDni(String dni);
	 
	 /**
	  * Metodo derivado para buscar un alumno por su dni
	  * @param dni es el dni por el que buscar al alumno
	  * @return opcionalmente devuelve un alumno si este lo encuentra por su dni
	  */
	 Optional<Alumno> findByDni(String dni);
}
