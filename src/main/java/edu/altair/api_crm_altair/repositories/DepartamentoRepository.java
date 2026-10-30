package edu.altair.api_crm_altair.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> 
{
	// Método derivado para consultar si ya existe un código registrado
	 boolean existsByCodigo(int codigo);
	 // Método derivado para buscar un departamento por su codigo
	 Optional<Departamento> findByCodigo(int codigo);
}
