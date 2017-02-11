/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Vicente
 */
@Local
public interface PersonaDaoLocal {

    List listPersonas();

    void addPersona(Persona persona);

    void updatePersona(Persona persona);

    Persona findPersonaById(Persona persona);

    Persona findPersonaByEmail(Persona persona);

    void deletePersona(Persona persona);
    
}
