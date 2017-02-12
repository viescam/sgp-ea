<%-- 
    Document   : agregarLibro
    Created on : 12-feb-2017, 10:57:48
    Author     : Vicente
--%>

<%@page import="com.fpmislata.domain.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Libro</title>
    </head>
    <body>
        <h1>Agregar Libro</h1>
        
        <form action="AltaLibro" method="post">
            <input type="hidden" name="accion" value="agregar"/>
            
            <label for="titulo">Título:</label>
            <input type="text" name="titulo" style="display: block" />
            
            <label for="autor">Autor:</label>
            <input type="text" name="autor" style="display: block" />
            
            <label for="anyo">Año:</label>
            <input type="text" name="anyo" style="display: block" />
            
            <label for="propietario">Propietario:</label>
            <input type="text" name="propietario" style="display: block" />
            <% 
                ArrayList<Persona> lista = (ArrayList)session.getAttribute("personas");
                for(Persona persona : lista){
                    int id = persona.getId();
                    String nombre = persona.getNombre();
                    String email = persona.getEmail();                    
                            
            %>
            <option value="<%=id%>"><%=nombre%> - <%=email%></option> 
            <% } %>
            <input type="submit" value="Enviar"/>
        </form>
            
        <a href="index.jsp">Regresar al inicio</a>    
    </body>
</html>
