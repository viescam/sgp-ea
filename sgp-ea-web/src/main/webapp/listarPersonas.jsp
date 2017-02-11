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
        
	<a href="agregarPersona.jsp">Agregar Persona</a>
	<br/>
	<br/>

	<table border="1">
		<tr>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Telefono</th>
                    <th></th>
                    <th></th>
 
		</tr>

                <%
                ArrayList<Persona> lista = (ArrayList) session.getAttribute("personas");
                for(Persona persona : lista){
                    
                    int id = persona.getId();
                    String nombre = persona.getNombre();
                    String email = persona.getEmail();
                    String telefono = persona.getTelefono();
                %>                
		<tr>
                    <td><%=nombre%></a></td>
                    <td><%=email%></td>
                    <td><%=telefono%></td>
                    <td><a href="ModificarPersona?accion=editar&id=<%=id%>">Modificar</td>
                    <td><a href="EliminarPersona?id=<%=id%>">Eliminar</a></td>
                </tr>
                <% } %>
	</table>
	<br>
	<a href="index.jsp">Regresar al Inicio</a>
</body>
</html>