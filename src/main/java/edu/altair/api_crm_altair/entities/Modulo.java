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
@Table(name = "modulos", schema = "altair_crm", uniqueConstraints = {
		@UniqueConstraint(name = "uk_modulos_codigoModulo", columnNames = "codigoModulo"),
		@UniqueConstraint(name = "uk_modulos_diminutivoModulo", columnNames = "diminutivoModulo")
})
public class Modulo 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idModulo", nullable = false)
    private Long idModulo;

    @Column(name = "codigoModulo", nullable = false, length = 4)
    private int codigo;
    
    @Column(name = "diminutivoModulo", nullable = false, length = 4)
    private String diminutivo;
    
    @Column(name = "nombreModulo", nullable = false, length = 45)
    private String nombre;

    @Column(name = "descripcionModulo", length = 255)
    private String descripcion;
    
    @Column(name = "horasSemanales")
    private int horasSemanales;
    
    @Column(name = "creditos")
    private int creditos;
}