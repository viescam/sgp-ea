/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Vicente
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Coche.findAll", query = "SELECT p FROM Coche p ORDER BY p.id")})
@Table(name = "coches")
public class Coche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coche")
    private int id;
    
    @Column(nullable = false, length = 45)
    private String marca;
    
    @Column(nullable = false, length = 45)
    private String modelo;
    
    @Column(nullable = false, length = 8)
    private String matricula;
    
    @Column(nullable = false, length = 45)
    private String color;
    
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Persona persona;

    public Coche(String marca, String modelo, String matricula, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.color = color;
    }

    public Coche() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
