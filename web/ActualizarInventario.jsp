<%-- 
    Document   : ActualizarInventario
    Created on : 30/11/2021, 03:39:08 PM
    Author     : Mikaela Estefania Ramirez Herrera <Estefania_mikaela@hotmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "java.sql.*" %>

<%
    /* Paso 1) Obtener los datos del formulario */
    String nombre = request.getParameter("Nombre");
    String precio = request.getParameter("Precio");
    String stock = request.getParameter("Stock");
    String id = request.getParameter("ID");
    String ls_action = request.getParameter("Action");

    /* Paso 2) Inicializar variables */
    String ls_result = "Base de datos actualizada...";
    String ls_query = "";
    String ls_dburl = "jdbc:mysql://localhost:3306/microtienda";
    String ls_usuario = "root";
    String ls_password = "";
    String ls_dbdriver = "com.mysql.jdbc.Driver";

    if (ls_action.equals("Eliminar")) {
        ls_query = " delete from productos where IdProducto = ";
        ls_query += "'" + id + "'";
    }

    if (ls_action.equals("Actualizar")) {
        ls_query = " update productos";
        ls_query += " set Nombre= " + "'" + nombre + "',";
        ls_query += " Precio= " + "'" + precio + "',";
        ls_query += " Stock= " + "'" + stock + "'";
        ls_query += " where IdProducto = " + "'" + id + "'";
    }

    /* Paso4) Conexión a la base de datos */
    Connection l_dbconn = null;

    try {
        Class.forName(ls_dbdriver);
        l_dbconn = DriverManager.getConnection(ls_dburl, ls_usuario, ls_password);

        /*Creación de SQL Statement */
        Statement l_statement = l_dbconn.createStatement();
        /* Ejecución de SQL Statement */
        l_statement.execute(ls_query);
    } catch (ClassNotFoundException e) {
        ls_result = " Error creando el driver!";
        ls_result += " <br/>" + e.toString();
    } catch (SQLException e) {
        ls_result = " Error procesando el SQL!";
        ls_result += " <br/>" + e.toString();
    } finally {
        /* Cerramos */
        try {
            if (l_dbconn != null) {
                l_dbconn.close();
            }
        } catch (SQLException e) {
            ls_result = "Error al cerrar la conexión.";
            ls_result += " <br/>" + e.toString();
        }
    }
%>
<html>
    <head>
        <meta charset="utf-8">
        <title><%=ConstantesApp.NAME_APP%></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><%=ConstantesApp.NAME_APP%></title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>

    <!-- Header/Navigation --> 
    <%@include file="WEB-INF/jspf/headerPrincipal.jsp" %> 
    <!-- /End of Header/Navigation -->
    <body><td>
        <div class="padre">
            <h1> <%=ls_result%> Corectamente</h1>
            </div>
    </body>
</html>

