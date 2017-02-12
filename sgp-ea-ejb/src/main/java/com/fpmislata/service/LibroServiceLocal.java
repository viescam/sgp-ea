/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Libro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Vicente
 */
@Local
public interface LibroServiceLocal {

    List listLibros();

    void addLibro(Libro libro);

    Libro findLibroById(Libro libro);

    void updateLibro(Libro libro);

    void deleteLibro(Libro libro);
    
}
