package edu.altair.api_crm_altair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> 
{
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
