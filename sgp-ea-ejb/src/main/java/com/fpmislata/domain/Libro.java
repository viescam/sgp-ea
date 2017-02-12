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
@NamedQuery(name = "Libro.findAll", query = "SELECT p FROM Libro p ORDER BY p.id")})
@Table(name = "libros")
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private int id;
    
    @Column(nullable = false, length = 100)
    private String titulo;
    
    @Column(nullable = false, length = 100)
    private String autor;
    
    @Column(nullable = false)
    private int anyo;
    
    @ManyToOne
    @JoinColumn(name = "persona")
    private Persona persona;

    public Libro() {
    }

    public Libro(String titulo, String autor, int anyo) {
        this.titulo = titulo;
        this.autor = autor;
        this.anyo = anyo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
