<%@page import="com.fpmislata.domain.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado Personas</title>
    </head>
    <body>

        <h1>Listado de Personas</h1>
        <h2>Versión con controlados</h2>
        

        <a href="agregarPersona.jsp">Agregar Persona</a>
        <br/>
        <br/>

        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Email</th>
                <th>Telefono</th>
                <th>Numero socio</th>
                <th>Direccion</th>
                <th>Poblacion</th>
                <th>Código Postal</th>
                <th>Provincia</th>
                <th> </th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Matrícula</th>
                <th>Color</th>
                <th></th>
                <th></th>
                <th>Visualizar libros</th>

            </tr>

            <%
                ArrayList<Persona> lista = (ArrayList) session.getAttribute("personas");
                for (Persona persona : lista) {

                    int id = persona.getId();
                    String nombre = persona.getNombre();
                    String email = persona.getEmail();
                    String telefono = persona.getTelefono();
                    int socio = persona.getSocio().getNumSocio();
                    String direccion = persona.getDireccion().getDireccion();
                    String poblacion = persona.getDireccion().getPoblacion();
                    String codigoPostal = persona.getDireccion().getCodigoPostal();
                    String provincia = persona.getDireccion().getProvincia();
                    String marca = persona.getCoche().getMarca();
                    String modelo = persona.getCoche().getModelo();
                    String matricula = persona.getCoche().getMatricula();
                    String color = persona.getCoche().getColor();
            %>                
            <tr>
                <td><%=nombre%></a></td>
                <td><%=email%></td>
                <td><%=telefono%></td>
                <td><%=socio%></td>
                <td><%=direccion%></td>
                <td><%=poblacion%></td>
                <td><%=codigoPostal%></td>
                <td><%=provincia%></td>
                <td> </td>
                <td><%=marca%></td>
                <td><%=modelo%></td>
                <td><%=matricula%></td>
                <td><%=color%></td>
                <td><a href="ModificarPersona?accion=editar&id=<%=id%>">Modificar</td>
                <td><a href="EliminarPersona?id=<%=id%>">Eliminar</a></td>
                <td><a href="ListarLibrosPorPersona?id=<%=id%>">Visualizar libros</a></td>
            </tr>
            <% }%>
        </table>
        <br>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>