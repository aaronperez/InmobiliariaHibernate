
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h1>Insert</h1>
    <form action="control" method="POST">
        Localidad: <input type="text" name="localidad" value="" />
        Tipo: <input type="text" name="tipo" value="" />
        Dirección: <input type="text" name="direccion" value="" />
        Precio: <input type="number" min="0" name="precio" value="" />
        <br>
        <input type="hidden" name="target" value="inmueble" />
        <input type="hidden" name="op" value="insert" />
        <input type="hidden" name="action" value="op" />
        <input type="submit" value="insertar" />
    </form>
</body>
</html>