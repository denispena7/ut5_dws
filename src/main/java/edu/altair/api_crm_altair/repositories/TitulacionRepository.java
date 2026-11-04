package edu.altair.api_crm_altair.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Titulacion;

/**
 *  Repositorio para la entidad Titulacion, con sus metodos heredados para la entidad
 *  @author csi26-denis
 *  @version 2026
 */

@Repository
public interface TitulacionRepository extends JpaRepository<Titulacion, Long> 
{
	/**
	 * Metodo derivado para consultar si ya existe un codigo registrado para cada titulacion
	 * @param codigo es el codigo de la titulacion
	 * @return boolean si el la titulacion existe o no
	 */
	 boolean existsByCodigo(int codigo);
	 
	 /**
	  * Metodo derivado para buscar una titulacion por su codigo
	  * @param codigo es el codigo por el que buscar la titulacion
	  * @return opcionalmente devuelve una titulacion si esta lo encuentra por su codigo
	  */
	 Optional<Titulacion> findByCodigo(int codigo);
	 
		/**
		 * Metodo derivado para consultar si ya existe un diminutivo registrado para cada titulacion
		 * @param diminutivo es el diminutivo de la titulacion
		 * @return boolean si el la titulacion existe o no
		 */
	 boolean existsByDiminutivo(String diminutivo);
	 
	 /**
	  * Metodo derivado para buscar una titulacion por su diminutivo
	  * @param diminutivo es el diminutivo por el que buscar la titulacion
	  * @return opcionalmente devuelve una titulacion si esta lo encuentra por su diminutivo
	  */
	 Optional<Titulacion> findByDiminutivo(String diminutivo);
}
