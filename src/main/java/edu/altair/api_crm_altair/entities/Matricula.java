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
@Table(name = "matriculas", schema = "altair_crm",
       uniqueConstraints = {
           @UniqueConstraint(
               name = "uk_modulo_alumno_estado",
               columnNames = {"idModulo", "idAlumno", "idEstado"}
           )
       })
public class Matricula 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMatricula", nullable = false)
    private Long idMatricula;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idModulo", foreignKey = @ForeignKey(name = "fk_modulo_alumno_estado"))
    private Modulo modulo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAlumno", foreignKey = @ForeignKey(name = "fk_alumno_estado_modulo"))
    private Alumno alumno;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstado", foreignKey = @ForeignKey(name = "fk_estado_alumno_modulo"))
    private Estado estado;
}
