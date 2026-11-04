package edu.altair.api_crm_altair.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Profesor;

/**
 *  Repositorio para la entidad Profesor, con sus metodos heredados para la entidad
 *  @author csi26-denis
 *  @version 2026
 */

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> 
{
	/**
	 * Metodo derivado para consultar si ya existe un profesor por su dni 
	 * @param dni es el dni del profesor
	 * @return boolean si el profesor existe o no
	 */
	 boolean existsByDni(String dni);
	 
	 /**
	  * Metodo derivado para buscar un profesor por su dni
	  * @param dni es el dni por el que buscar al profesor
	  * @return opcionalmente devuelve un profesor si este lo encuentra por su dni
	  */
	 Optional<Profesor> findByDni(String dni);
}