/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Persona;
import com.fpmislata.repository.PersonaDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PersonaService implements PersonaServiceLocal {

    @EJB
    private PersonaDaoLocal personaDao;  
        

    public List listPersonas() {
        return personaDao.listPersonas();
    }

    @Override
    public void addPersona(Persona persona) {
        // Comprobamos que la persona no existe por el email
        Persona p = personaDao.findPersonaByEmail(persona);
        if(p==null){
            personaDao.addPersona(persona);
        }
        
    }

    @Override
    public void updatePersona(Persona persona) {
        personaDao.updatePersona(persona);
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        return personaDao.findPersonaById(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        personaDao.deletePersona(persona);
    }
    
    
    
}
