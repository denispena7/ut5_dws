package edu.altair.api_crm_altair.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.altair.api_crm_altair.entities.Prof_Imparte_Mod;

@Repository	
public interface Prof_Imparte_ModRepository extends JpaRepository<Prof_Imparte_Mod, Long> 
{
    List<Prof_Imparte_Mod> findAllByModulo_IdModulo(Long idModulo);

    List<Prof_Imparte_Mod> findAllByProfesor_IdProfesor(Long idProfesor);

    boolean existsByProfesor_IdProfesorAndModulo_IdModulo(
            Long idProfesor, Long idModulo);
}
