
<%@page import="java.util.List"%>
<%@page import="hibernate.Inmueble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>INDEX</h1>
        <h2>
            <a href="control?target=inmueble&op=insert&action=view">insertar registro</a>
        </h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Localidad</th>
                    <th>Dirección</th>
                    <th>Tipo</th>
                    <th>Precio</th>
                    <th>Usuario</th>
                    <th>Fecha de alta</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Inmueble> lista = (List)request.getAttribute("datos");
                    for(Inmueble i: lista){
                        %>
                <tr>
                    <td><%= i.getLocalidad()%></td>
                    <td><%= i.getDireccion() %></td>
                    <td><%= i.getTipo() %></td>
                    <td><%= i.getPrecio().toString() %></td>
                    <td><%= i.getUsuario()%></td>
                    <td><%= i.getFechaalta().toString() %></td>
                    <td><a href="control?target=inmueble&op=viewfoto&action=view&id=<%= i.getId() %>">Ver fotos</a></td>
                    <td><a href="control?target=inmueble&op=addfoto&action=view&id=<%= i.getId() %>">Subir foto</a></td>
                    <td><a href="control?target=inmueble&op=delete&action=op&id=<%= i.getId() %>">Borrar</a></td>
                    <td><a href="control?target=inmueble&op=edit&action=view&id=<%= i.getId() %>">Editar</a></td>
                </tr>
                <%
                    }
                %>
                
            </tbody>
        </table>

    </body>
</html>
