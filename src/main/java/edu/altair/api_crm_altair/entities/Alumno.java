package edu.altair.api_crm_altair.entities;

import java.time.LocalDate;

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
@Table(name = "alumnos", schema = "altair_crm", uniqueConstraints = {
        @UniqueConstraint(name = "uk_alumnos_dniAlumno", columnNames = "dniAlumno"),
        @UniqueConstraint(name = "uk_alumnos_numeroSS", columnNames = "numeroSS")
})
public class Alumno 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlumno", nullable = false)
    private Long idAlumno;

    @Column(name = "nombreAlumno", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellidosAlumno", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "dniAlumno", nullable = false, length = 9)
    private String dni;

    @Column(name = "numeroSS", length = 15)
    private String numeroSS;

    @Column(name = "emailPersonal", length = 100)
    private String emailPersonal;

    @Column(name = "telefonoPersonal", length = 15)
    private String telefonoPersonal;

    @Column(name = "fechaAlta", nullable = false)
    private LocalDate fechaAlta;

    @Column(name = "fechaBaja")
    private LocalDate fechaBaja;

    @Column(name = "emailCentro", length = 100)
    private String emailCentro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFamilia", foreignKey = @ForeignKey(name = "fk_alumnos_familia"))
    private Familia familia;
}
