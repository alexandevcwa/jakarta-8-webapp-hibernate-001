<%-- 
    Document   : index
    Created on : Jul 26, 2024, 9:17:16 PM
    Author     : AlexanDev_CWA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>NUEVO CLIENTE</h1>
        <form action="SvClient" method="POST">
            <p><label>Nombre: </label> <input type="text" required="true" name="name"></p>
            <p><label>Dirección: </label> <input type="text" required="true" name="address"></p>
            <p><label>NIT: </label> <input type="text" required="true" name="nit"></p>
            <p><label>Correo: </label> <input type="email" required="true" name="email"></p>
            <p><label>Contraseña: </label> <input type="password" required="true" name="password"></p>
            <p><label>Teléfono: </label> <input type="phone" required="true" name="phone"></p>
            <button type="submit">GUARDAR CLIENTE</button>
        </form>
    </body>
</html>
