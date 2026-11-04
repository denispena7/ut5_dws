package edu.altair.api_crm_altair.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.ModCur;

/**
 *  Repositorio para la entidad ModCur, con sus metodos heredados para la entidad
 *  @author csi26-denis
 *  @version 2026
 */

@Repository
public interface ModCurRepository extends JpaRepository<ModCur, Long> 
{
	 /**
	  * Metodo derivado para reflejar la relacion cursos-modulo
	  * @param idModulo es el id del modulo
	  * @return lista para la relacion cursos-modulo
	  */
    List<ModCur> findAllByModulo_IdModulo(Long idModulo);

	 /**
	  * Metodo derivado para reflejar la relacion modulos-curso
	  * @param idcurso es el id del curso
	  * @return lista para la relacion modulos-curso
	  */
    List<ModCur> findAllByCurso_IdCurso(Long idCurso);

	/**
	 * Metodo derivado para consultar si ya existe la relacion
	 * @param idModulo es el id del modulo
	 * @param idcurso es el id del curso
	 * @return boolean si el la relacion existe o no
	 */
    boolean existsByCurso_IdCursoAndModulo_IdModulo(
            Long idCurso, Long idModulo);
}