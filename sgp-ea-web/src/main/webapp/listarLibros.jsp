<%-- 
    Document   : listarLibros
    Created on : 12-feb-2017, 10:49:50
    Author     : Vicente
--%>

<%@page import="com.fpmislata.domain.Libro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Libros</title>
    </head>
    <body>
        <h1>Listado de Libros</h1>
        <h2>Versión con controlador</h2>
        
        <a href="agregarLibro.jsp">Agregar Libro</a>
        <br>
        <br>
        
        <table border="1">
            <tr>
                <th>id</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Año</th>
                <th>Propietario</th>
                <th></th>
                <th></th>
            </tr>
            <% ArrayList<Libro> lista = (ArrayList)session.getAttribute("libros");
            for(Libro libro : lista){
                
                int id = libro.getId();
                String titulo = libro.getTitulo();
                String autor = libro.getAutor();
                String anyo = String.valueOf(libro.getAnyo());
                String propietario = libro.getPersona().getNombre();
            %>
            <tr>
                <td><%=id%></td>
                <td><%=titulo%></td>
                <td><%=autor%></td>
                <td><%=anyo%></td>
                <td><%=propietario%></td>
                <td><a href="ModificarLibro?accion=editar&id=<%=id%>">Modificar</a></td>
                <td><a href="EliminarLibro?id=<%=id%>">Modificar</a></td>
            </tr>
            <%}%>
        </table>
        <br>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
