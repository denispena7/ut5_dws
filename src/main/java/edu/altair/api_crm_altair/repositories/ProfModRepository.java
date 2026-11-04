package edu.altair.api_crm_altair.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.altair.api_crm_altair.entities.ProfMod;

/**
 *  Repositorio para la entidad ProfMod, con sus metodos heredados para la entidad
 *  @author csi26-denis
 *  @version 2026
 */

@Repository	
public interface ProfModRepository extends JpaRepository<ProfMod, Long> 
{
	 /**
	  * Metodo derivado para reflejar la relacion profesores-modulo
	  * @param idModulo es el id del modulo
	  * @return lista para la relacion profesores-modulo
	  */
    List<ProfMod> findAllByModulo_IdModulo(Long idModulo);

	 /**
	  * Metodo derivado para reflejar la relacion modulos-profesor
	  * @param idProfesor es el id del profesor
	  * @return lista para la relacion modulos-profesor
	  */
    List<ProfMod> findAllByProfesor_IdProfesor(Long idProfesor);

	/**
	 * Metodo derivado para consultar si ya existe la relacion
	 * @param idProfesor es el id del profesor
	 * @param idModulo es el id del modulo
	 * @return boolean si la relacion existe o no
	 */
    boolean existsByProfesor_IdProfesorAndModulo_IdModulo(
            Long idProfesor, Long idModulo);
}
