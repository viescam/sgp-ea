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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT p FROM Socio p "
            + "ORDER BY p.id")})
@Table(name = "socios")
public class Socio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int id;
    @Column(name = "num_socio")
    private int numSocio;

    public int getNumSocio() {
        return numSocio;
    }    


    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Socio() {
    }

    public Socio(int numSocio) {
        this.numSocio = numSocio;
    }

    public Socio(int id, int numSocio) {
        this.id = id;
        this.numSocio = numSocio;
    }
}
