/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author lodiade
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p ORDER BY p.id")})
@Table(name = "personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int id;

    @Column(nullable = false, length = 45)
    private String nombre;

    @Column(length = 45)
    private String email;

    @Column(length = 20)
    private String telefono;
    
    @OneToOne(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Socio socio;
    
    @OneToOne(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinColumn(name="direccion")
    private Direccion direccion;
    
    @OneToOne(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Coche coche;
    
    /*@OneToMany(mappedBy="persona", cascade={CascadeType.ALL},fetch=FetchType.EAGER)
    private Set<Libro> libros;*/
    
    @OneToMany(mappedBy="persona", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @OrderColumn(name="order")//(name="idx")
    private Set<Libro> libros;
    

    public Persona() {
        this.libros = new HashSet<>();
    }

    public Persona(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.libros = new HashSet<>();
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }
       
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
