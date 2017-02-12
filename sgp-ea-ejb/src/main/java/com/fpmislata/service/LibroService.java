/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Libro;
import com.fpmislata.repository.LibroDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Vicente
 */
@Stateless
public class LibroService implements LibroServiceLocal {

    @EJB
    private LibroDaoLocal libroDao;
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listLibros() {
        return libroDao.listLibros();
    }

    @Override
    public void addLibro(Libro libro) {
        libroDao.addLibro(libro);
    }

    @Override
    public Libro findLibroById(Libro libro) {
        return libroDao.findLibroById(libro);
    }

    @Override
    public void updateLibro(Libro libro) {
        libroDao.updateLibro(libro);
    }

    @Override
    public void deleteLibro(Libro libro) {
        libroDao.deleteLibro(libro);
    }
    
    
    
    
    
    
    
    
    
}
