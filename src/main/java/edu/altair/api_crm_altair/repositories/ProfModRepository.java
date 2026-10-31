package edu.altair.api_crm_altair.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.altair.api_crm_altair.entities.ProfMod;

@Repository	
public interface ProfModRepository extends JpaRepository<ProfMod, Long> 
{
    List<ProfMod> findAllByModulo_IdModulo(Long idModulo);

    List<ProfMod> findAllByProfesor_IdProfesor(Long idProfesor);

    boolean existsByProfesor_IdProfesorAndModulo_IdModulo(
            Long idProfesor, Long idModulo);
}
