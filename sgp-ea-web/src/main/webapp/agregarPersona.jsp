<%-- 
    Document   : agregarPersona.jsp
    Created on : 07-nov-2016, 8:36:25
    Author     : lodiade
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Agregar Persona</title>
    </head>
    <body>

        <h1>Agregar Persona</h1>

        <form action="AltaPersona" method="post">
            <input type="hidden" name="accion" value="agregar"/>

            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" style="display: block;" />

            <label for="email">eMail:</label>
            <input type="text" name="email" style="display: block;"/>

            <label for="telefono">Teléfono:</label>
            <input type="text" name="telefono" style="display: block;"/>

            <label for="numSocio">Numero socio:</label>
            <input type="text" name="numSocio" style="display: block;"/>

            <label for="direccion">Direccion:</label>
            <input type="text" name="direccion" style="display: block;"/>

            <label for="poblacion">Población:</label>
            <input type="text" name="poblacion" style="display: block;"/>

            <label for="codigoPostal">Código Postal:</label>
            <input type="text" name="codigoPostal" style="display: block;"/>

            <label for="provincia">Provincia:</label>
            <input type="text" name="provincia" style="display: block;"/>

            <br>
            <hr width="100%" align="left">
            <h3>Datos del coche</h3>
            <br>
            
            <label for="marca">Marca:</label>
            <input type="text" name="marca" style="display: block;" />
            
            <label for="modelo">Modelo:</label>
            <input type="text" name="modelo" style="display: block;" />
            
            <label for="matricula">Matrícula:</label>
            <input type="text" name="matricula" style="display: block;" />
            
            <label for="color">Color:</label>
            <input type="text" name="color" style="display: block;" />


            <input type="submit" value="Enviar" />
        </form>

        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
