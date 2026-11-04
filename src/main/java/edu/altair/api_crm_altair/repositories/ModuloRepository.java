package edu.altair.api_crm_altair.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Modulo;

/**
 *  Repositorio para la entidad Modulo, con sus metodos heredados para la entidad
 *  @author csi26-denis
 *  @version 2026
 */

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> 
{
	/**
	 * Metodo derivado para consultar si ya existe un modulo por su codigo
	 * @param codigo es elcodigo del modulo
	 * @return boolean si el el modulo existe o no
	 */
	 boolean existsByCodigo(int codigo);
	 
	 /**
	  * Metodo derivado para buscar un modulo por su codigo
	  * @param codigo es el codigo por el que buscar al modulo
	  * @return opcionalmente devuelve un modulo si este lo encuentra por su codigo
	  */
	 Optional<Modulo> findByCodigo(int codigo);
	 
	/**
	 * Metodo  derivado para consultar si ya existe un modulo por su diminutivo
	 * @param diminutivo es el diminutivo del modulo
	 * @return boolean si el el modulo existe o no
	 */
	 boolean existsByDiminutivo(String diminutivo);
	 
	 /**
	  * Metodo derivado para buscar un modulo por su diminutivo
	  * @param diminutivo es el diminutivo por el que buscar al modulo
	  * @return opcionalmente devuelve un modulo si este lo encuentra por su codigo
	  */
	 Optional<Modulo> findByDiminutivo(String diminutivo);
}