<%-- 
    Document   : headerAdministrador
    Created on : 2/12/2017, 11:42:10 AM
    Author     : xykukulkan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dto.Usuario"%>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");
String encabezado = "Since 1980";
String logout = "";
int rol = 2;
%>
<%if (usuario != null) {
    encabezado = usuario.toString();
    rol = usuario.getDatosLogin().getIdRol();    
    logout = ("<a class='dropdown-item' href='../Logout'>Log-Out</a>");
    
    if(rol != 1){
        //response.sendRedirect("../index.jsp");
    }
}else{
    response.sendRedirect("../index.jsp");
}%>

<header>
     <nav class="navbar navbar-light bg-faded" id="menu">
      <a class="navbar-brand mx-auto" href="#">
        <div class="texto-blanco" align="center">
          <img src="../images/logo.jpg" width="60" height="45" class="d-inline-block align-top" alt=""> T-Shirt Print 
          <br>
            <small><p class="mb-0" id="slogan"><%=encabezado%></p></small>
          <button class="navbar-toggler navbar-toggler-right hidden-sm-up" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar2">
          &#9776;
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
      </a>
      
      <div class="collapse navbar-toggleable-xs" id="exCollapsingNavbar2">
        <ul class="nav navbar-nav pull-xs-right ml">
          <li class="nav-item">
            <a class="nav-link" href="../index.jsp">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="#" id="ver_usuario">Ver Usuarios</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Ver Pedidos</a>
          </li>
          <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Usuario
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" href="../login.jsp">Ingresar</a>
                  <a class="dropdown-item" href="../register.jsp">Registrarse</a>
                  <%=logout%>
                </div>
          </li>
        </ul>
      </div>
    </nav>
</header>

