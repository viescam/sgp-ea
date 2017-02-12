/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Libro;
import com.fpmislata.domain.Persona;
import com.fpmislata.service.LibroServiceLocal;
import com.fpmislata.service.PersonaServiceLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerLibros",
        loadOnStartup = 1,
        urlPatterns = {"/ListarLibros",
            "/AltaLibro",
            "/ListarLibrosPorPersona",
            "/ControllerLibro"})
public class ControllerLibros extends HttpServlet {

    @EJB
    private PersonaServiceLocal personaService;
    @EJB
    private LibroServiceLocal libroService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        // Si la operacion es listar libros
        if (userPath.equals("/ListarLibros")) {
            listarLibros(request, response);
        // Si la operacion es Alta Libro
        } else if (userPath.equals("/AltaLibro")) {
            altaLibro(request, response);
        // Si la operacion es Listar libros por persona
        } else if (userPath.equals("/ListarLibrosPorPersona")) {
            listarLibroPorPersona(request, response);
        } else if (userPath.equals("/ControllerLibro")) {
            listarLibros(request, response);
        }
    }

    private void listarLibros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Ejecutamos el metodo y obtenemos la lista
            List listaLibros = libroService.listLibros();
            // Asignamos al request el atributo lista
            ArrayList<Libro> listaArrayLibro = new ArrayList<>(listaLibros);
            request.getSession().setAttribute("libros", listaArrayLibro);
            // Como podemos agregar libros necesitamos cargar las personas
            List listaPersonas = personaService.listPersonas();
            ArrayList<Persona> listaArrayPersonas = new ArrayList<>(listaPersonas);
            request.getSession().setAttribute("personas", listaArrayPersonas);
            // Pasamos al RequestDispatcher la pagina a cargar
            RequestDispatcher rd = request.getRequestDispatcher("/listarLibros.jsp");
            // Cargamos la pagina
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void altaLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1. Recuperamos los parametros del libro
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        int anyo = Integer.parseInt(request.getParameter("anyo"));
        int id_persona = Integer.parseInt(request.getParameter("propietario"));
        //2. Creamos el objeto Libro
        Libro libro = new Libro(titulo, autor, anyo);
        //3. Recuperamos el objeto Persona y asignamos el libro
        Persona persona = new Persona();
        persona.setId(id_persona);
        persona = personaService.findPersonaById(persona);
        //4. Asignamos los valores
        libro.setPersona(persona);
        persona.getLibros().add(libro);
        try {
            libroService.addLibro(libro);
            personaService.updatePersona(persona);
        } catch (Exception e) {
        //Informamos cualquier error
            e.printStackTrace();
        }
        listarLibros(request, response);
    }

    private void listarLibroPorPersona(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1. Recuperamos los parametros de la persona
            String id = request.getParameter("id");
            Persona p = new Persona();
            p.setId(Integer.valueOf(id));
            p = personaService.findPersonaById(p);
            // Asignamos al request el atributo lista
            ArrayList<Libro> listaArrayLibro = new ArrayList<>(p.getLibros());
            request.getSession().setAttribute("libros", listaArrayLibro);
            // Pasamos al RequestDispatcher la pagina a cargar
            RequestDispatcher rd = request.getRequestDispatcher("/listarLibros.jsp");
            // Cargamos la pagina
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign 
        //    on the left to edit the code.     ">
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
