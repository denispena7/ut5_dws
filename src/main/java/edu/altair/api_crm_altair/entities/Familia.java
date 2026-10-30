package edu.altair.api_crm_altair.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "familias", schema = "altair_crm")
public class Familia 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFamilia", nullable = false)
    private Long idFamilia;
    
    @Column(name = "nombreMadre", nullable = false, length = 45)
    private String nombre_madre;
    
    @Column(name = "nombrePadre", nullable = false, length = 45)
    private String nombre_padre;
    
    @Column(name = "apellidosMadre", nullable = false, length = 45)
    private String apellidos_madre;
    
    @Column(name = "apellidosPadre", nullable = false, length = 45)
    private String apellidos_padre;
    
    @Column(name = "emailMadre", nullable = false, length = 100)
    private String email_madre;
    
    @Column(name = "emailPadre", nullable = false, length = 100)
    private String email_padre;
    
    @Column(name = "telefonoMadre", nullable = false, length = 15)
    private String telefono_madre;
    
    @Column(name = "telefonoPadre", nullable = false, length = 15)
    private String telefono_padre;
    
    @Column(name = "direccionMadre", nullable = false, length = 100)
    private String direccion_madre;
    
    @Column(name = "direccionPadre", nullable = false, length = 100)
    private String direccion_padre;
    
    @Column(name = "cpMadre", nullable = false, length = 5)
    private int cp_madre;
    
    @Column(name = "cpPadre", nullable = false, length = 5)
    private int cp_padre;
    
    @Column(name = "municipioMadre", nullable = false, length = 45)
    private String municipio_madre;
    
    @Column(name = "municipioPadre", nullable = false, length = 45)
    private String municipio_padre;
    
    @Column(name = "provinciaMadre", nullable = false, length = 45)
    private String provincia_madre;
    
    @Column(name = "provinciaPadre", nullable = false, length = 45)
    private String provincia_padre;
    
    @Column(name = "son_separados", nullable = false)
    private Boolean son_separados;
    
    @Column(name = "es_compartido", nullable = false)
    private Boolean es_compartido;
    
    @Column(name = "es_madre", nullable = false)
    private Boolean es_madre;
    
    @Column(name = "es_padre", nullable = false)
    private Boolean es_padre;
}