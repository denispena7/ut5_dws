package edu.altair.api_crm_altair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {}
