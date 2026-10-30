package edu.altair.api_crm_altair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.Familia;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {}
