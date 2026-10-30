package edu.altair.api_crm_altair.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> 
{
	// Método derivado para consultar si ya existe un dni registrado
	 boolean existsByDni(String dni);
	 // Método derivado para buscar un departamento por su codigo
	 Optional<Profesor> findByDni(String dni);
}