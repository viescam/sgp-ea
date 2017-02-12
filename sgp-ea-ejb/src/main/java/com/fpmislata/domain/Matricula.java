/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

/**
 *
 * @author Vicente
 */
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "matriculas")
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula", nullable = false)    
    private Integer id;
    
    @Column(name = "notaFinal", nullable = false)
    private float notaFinal;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "asignatura")
    private Asignatura asignatura;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "persona")
    private Persona persona;

    public Matricula() {
    }

    public Matricula(Asignatura asignatura, Persona persona, float notaFinal) {
        this.asignatura = asignatura;
        this.persona = persona;
        this.notaFinal = notaFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

}
