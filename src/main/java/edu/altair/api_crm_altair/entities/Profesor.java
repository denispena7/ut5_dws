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
@Table(name = "profesores", schema = "altair_crm", uniqueConstraints = {
		@UniqueConstraint(name = "uk_profesores_dniProfesor", columnNames = "dniProfesor")
})
public class Profesor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfesor", nullable = false)
    private Long idProfesor;
    
    @Column(name = "nombreProfesor", nullable = false, length = 45)
    private String nombre;
    
    @Column(name = "apellidosProfesor", nullable = false, length = 45)
    private String apellidos;
    
    @Column(name = "dniProfesor", nullable = false, length = 9)
    private String dni;
    
    @Column(name = "emailCentro", length = 100)
    private String email_centro;
    
    @Column(name = "emailPersonal", length = 100)
    private String email_personal;
    
    @Column(name = "telefonoPersonal", length = 15)
    private String telefono_personal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDepartamento", foreignKey = @ForeignKey(name = "fk_profesores_departamento"))
    private Departamento departamento;
    
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "profImparteMod",
//        schema = "altair_crm",
//        joinColumns = @JoinColumn(name = "idProfesor"),
//        inverseJoinColumns = @JoinColumn(name = "idModulo")
//    )
//    private Set<Modulo> modulos  = new HashSet<>();
}