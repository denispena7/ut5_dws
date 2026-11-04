package edu.altair.api_crm_altair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Estado;

/**
 *  Repositorio para la entidad Estado, con sus metodos heredados para la entidad
 *  @author csi26-denis
 *  @version 2026
 */

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {}
