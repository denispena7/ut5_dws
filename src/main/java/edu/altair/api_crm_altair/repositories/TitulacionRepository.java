package edu.altair.api_crm_altair.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Titulacion;

@Repository
public interface TitulacionRepository extends JpaRepository<Titulacion, Long> 
{
	// Método derivado para consultar si ya existe un código registrado
	 boolean existsByCodigo(int codigo);
	 // Método derivado para buscar un departamento por su codigo
	 Optional<Titulacion> findByCodigo(int codigo);
	 
		// Método derivado para consultar si ya existe un diminutivo registrado
	 boolean existsByDiminutivo(String diminutivo);
	 // Método derivado para buscar un departamento por su codigo
	 Optional<Titulacion> findByDiminutivo(String diminutivo);
}
