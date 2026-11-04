package edu.altair.api_crm_altair.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Curso;

/**
 *  Repositorio para la entidad Curso, con sus metodos heredados para la entidad
 *  @author csi26-denis
 *  @version 2026
 */

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> 
{
	/**
	 * Método derivado para consultar si ya existe un diminutivo registrado
	 * @param diminutivo es el diminutivo del curso
	 * @return boolean si el el curso existe o no
	 */
	 boolean existsByDiminutivo(String diminutivo);
	 
	 /**
	  * Metodo derivado para buscar un curso por su diminutivo
	  * @param diminutivo es el diminutivo por el que buscar al curso
	  * @return opcionalmente devuelve un curso si este lo encuentra por su diminutivo
	  */
	 Optional<Curso> findByDiminutivo(String diminutivo);
}