package edu.altair.api_crm_altair.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.api_crm_altair.entities.ModCur;

@Repository
public interface ModCurRepository extends JpaRepository<ModCur, Long> 
{
    List<ModCur> findAllByModulo_IdModulo(Long idModulo);

    List<ModCur> findAllByCurso_IdCurso(Long idCurso);

    boolean existsByCurso_IdCursoAndModulo_IdModulo(
            Long idCurso, Long idModulo);
}