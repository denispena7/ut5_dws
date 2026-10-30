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
@Table(name = "estados", schema = "altair_crm")
public class Estado 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstado", nullable = false)
    private Long idEstado;
    
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "descripcionEstado", length = 255)
    private String descripcion;
}
