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
@Table(name = "profesores_modulos", schema = "altair_crm",
       uniqueConstraints = {
           @UniqueConstraint(
               name = "uk_profesor_modulo",
               columnNames = {"idProfesor", "idModulo"}
           )
       })
public class Prof_Imparte_Mod
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfesorModulo", nullable = false)
    private Long idProfesorModulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProfesor", foreignKey = @ForeignKey(name = "fk_profesor_modulo"))
    private Profesor profesor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idModulo", foreignKey = @ForeignKey(name = "fk_modulo_profesor"))
    private Modulo modulo;
}