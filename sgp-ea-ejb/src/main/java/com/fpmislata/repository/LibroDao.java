/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Libro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Vicente
 */
@Stateless
public class LibroDao implements LibroDaoLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName="LibroPU")
    EntityManager em;

    @Override
    public List listLibros() {
        List a = em.createNamedQuery("Libro.findAll").getResultList();
        return a;
    }

    @Override
    public void addLibro(Libro libro) {
        em.persist(libro);               
    }

    @Override
    public Libro findLibroById(Libro libro) {
        return em.find(Libro.class, libro.getId());
    }

    @Override
    public void updateLibro(Libro libro) {
        em.merge(libro);
    }

    @Override
    public void deleteLibro(Libro libro) {
        libro = findLibroById(libro);
        em.remove(libro);
    }
    
    
    
    
    
    
    
    
    
    
    
}
