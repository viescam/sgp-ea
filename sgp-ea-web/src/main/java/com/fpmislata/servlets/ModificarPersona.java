/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Persona;
import com.fpmislata.service.PersonaServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lodiade
 */
public class ModificarPersona extends HttpServlet {

    // Inyeccion de dependencias
    @EJB
    private PersonaServiceLocal personaService;
 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("editar")) {
            
            //1. Recuperamos el id de la persona seleccionada
            String idPersona = request.getParameter("id");
            if (idPersona != null) {
                //2. Creamos el objeto persona a recuperar
                int id = Integer.valueOf(idPersona);
                Persona persona = new Persona();
                persona.setId(id);
                try{              
                    persona = this.personaService.findPersonaById(persona);
                }catch(Exception e){
                    e.printStackTrace();
                }

                //3. Compartimos el objeto persona en alcance request
                request.setAttribute("persona", persona);

                //4. Redireccionamos a la pagina para editar el objeto Persona
                request.getRequestDispatcher("/modificarPersona.jsp").forward(request, response);
            }
        }else if  (accion != null && accion.equals("modificar")) {      

            //1. Recuperamos los parametros
            String idPersona = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            //2. Creamos el objeto Persona
            Persona persona = new Persona();
            int id = Integer.valueOf(idPersona);
            persona.setId(id);
            persona.setNombre(nombre);
            persona.setEmail(email);
            persona.setTelefono(telefono);

            try {
                this.personaService.updatePersona(persona);
            } catch (Exception e) {
                //Informamos cualquier error
                e.printStackTrace();
            }

            // Volvemos a cargar la lista de personas
            List<Persona> lista = personaService.listPersonas();
            request.setAttribute("personas", lista);

            request.getRequestDispatcher("/listarPersonas.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
