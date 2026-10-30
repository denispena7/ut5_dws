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
@Table(name = "titulaciones", schema = "altair_crm", uniqueConstraints = {
		@UniqueConstraint(name = "uk_modulos_codigoTitulacion", columnNames = "codigoTitulacion"),
		@UniqueConstraint(name = "uk_modulos_diminutivoTitulacion", columnNames = "diminutivoTitulacion")
})
public class Titulacion 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTitulacion", nullable = false)
    private Long idTitulacion;
    
    @Column(name = "codigoTitulacion", nullable = false, length = 4)
    private int codigo;

    @Column(name = "diminutivoTitulacion", nullable = false, length = 4)
    private String diminutivo;
    
    @Column(name = "horasTotales")
    private int horasTotales;
}
