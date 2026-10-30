package edu.altair.api_crm_altair.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "departamentos", schema = "altair_crm", uniqueConstraints = {
		@UniqueConstraint(name = "uk_departamentos_codigoDepartamento", columnNames = "codigoDepartamento")
})
public class Departamento 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartamento", nullable = false)
    private Long idDepartamento;

    @Column(name = "codigoDepartamento", nullable = false, length = 4)
    private int codigo;
    
    @Column(name = "nombreDepartamento", nullable = false, length = 45)
    private String nombre;

    @Column(name = "descripcionDepartamento", length = 255)
    private String descripcion;
    
    @Column(name = "telefonoDepartamento", length = 15)
    private String telefono;
}
