package edu.altair.api_crm_altair.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Departamento;

/**
 *  Repositorio para la entidad Departamento, con sus metodos heredados para la entidad
 *  @author csi26-denis
 *  @version 2026
 */

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> 
{
	/**
	 * Metodo derivado para consultar si ya existe un departamento por su codigo
	 * @param codigo es el codigo del departamento
	 * @return boolean si el el departamento existe o no
	 */
	 boolean existsByCodigo(int codigo);
	 
	 /**
	  * Metodo derivado para buscar un departamento por su codigo
	  * @param codigo es el codigo por el que buscar al departamento
	  * @return opcionalmente devuelve un departamento si este lo encuentra por su codigo
	  */
	 Optional<Departamento> findByCodigo(int codigo);
}
