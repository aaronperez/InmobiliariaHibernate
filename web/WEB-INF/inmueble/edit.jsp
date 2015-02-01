<%-- 
    Document   : edit
    Created on : 19-ene-2015, 12:16:36
    Author     : AngelakaMogu
--%>

<%@page import="hibernate.Inmueble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Inmueble i =(Inmueble)request.getAttribute("Inmueble");
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="control" method="POST">
        
        Localidad: <input type="text" name="localidad" value="<%= i.getLocalidad()%>" />
        Tipo: <input type="text" name="tipo" value="<%= i.getTipo()%>" />
        Dirección: <input type="text" name="direccion" value="<%= i.getDireccion()%>" />
        Precio: <input type="number" min="0" name="precio" value="<%= i.getPrecio()%>" />
        <br>
        <input type="hidden" name="target" value="inmueble" />
        <input type="hidden" name="op" value="edit" />
        <input type="hidden" name="action" value="op" />
        <input type="hidden" name="id" value="<%= i.getId()%>" />
        <input type="submit" value="Editar" />
    </form>
    </body>
</html>
