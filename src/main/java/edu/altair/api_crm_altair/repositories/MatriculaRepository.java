package edu.altair.api_crm_altair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Matricula;

/**
 *  Repositorio para la entidad Matricula, con sus metodos heredados para la entidad
 *  @author csi26-denis
 *  @version 2026
 */
@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> 
{
	/**
	 * Metodo personalizado para consultar si ya existe la matricula
	 * @param idModulo es el id del modulo
	 * @param idAlumno es el id del alumno
	 * @param idEstado es el id del estado
	 * @return boolean si la matricula existe o no
	 */
	@Query("""
		    SELECT COUNT(m) > 0
		    FROM Matricula m
		    WHERE m.modulo.idModulo = :idModulo
		      AND m.alumno.idAlumno = :idAlumno
		      AND m.estado.idEstado = :idEstado
		""")
		boolean existeMatricula(
		        @Param("idModulo") Long idModulo,
		        @Param("idAlumno") Long idAlumno,
		        @Param("idEstado") Long idEstado
		);
}
