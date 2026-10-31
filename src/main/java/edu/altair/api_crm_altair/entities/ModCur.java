package edu.altair.api_crm_altair.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "modulos_cursos", schema = "altair_crm",
       uniqueConstraints = {
           @UniqueConstraint(
               name = "uk_modulo_curso",
               columnNames = {"idModulo", "idCurso"}
           )
})
public class ModCur 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idModuloCurso", nullable = false)
    private Long idModuloCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idModulo", foreignKey = @ForeignKey(name = "fk_modulo_curso"))
    private Modulo modulo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCurso", foreignKey = @ForeignKey(name = "fk_curso_modulo"))
    private Curso curso;
}