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
@Table(name = "cursos", schema = "altair_crm", uniqueConstraints = {
		@UniqueConstraint(name = "uk_cursos_diminutivoCurso", columnNames = "diminutivoCurso")
})
public class Curso 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCurso", nullable = false)
    private Long idCurso;
    
    @Column(name = "diminutivoCurso", nullable = false, length = 4)
    private String diminutivo;

    @Column(name = "descripcionCurso", length = 255)
    private String descripcion;
}