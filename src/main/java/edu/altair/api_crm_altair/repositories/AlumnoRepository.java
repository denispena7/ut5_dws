package edu.altair.api_crm_altair.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> 
{
	// Método derivado para consultar si ya existe un dni registrado
	 boolean existsByDni(String dni);
	 // Método derivado para buscar un departamento por su codigo
	 Optional<Alumno> findByDni(String dni);
}
