package edu.altair.api_crm_altair.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> 
{
	// Método derivado para consultar si ya existe un diminutivo registrado
	 boolean existsByDiminutivo(String diminutivo);
	 // Método derivado para buscar un departamento por su codigo
	 Optional<Curso> findByDiminutivo(String diminutivo);
}