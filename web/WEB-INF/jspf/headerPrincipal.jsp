<%@page import="core.ConstantesApp"%>
<%@page import="dto.Usuario"%>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");
    String encabezado = "Accesorios para tu celular";
    String panelOculto = "";
    String logout = "";
    int rol = 0;
%>
<%if (usuario != null) {
        encabezado = usuario.toString();
        rol = usuario.getDatosLogin().getIdRol();
        logout = ("<a class='dropdown-item' href='FrontController?comando=Logout'>Log-Out</a>");
    } else {
        encabezado = ConstantesApp.LEYENDA_APP;
    }%>
<header>
    <nav class="navbar navbar-light bg-faded" id="menu">
        <a class="navbar-brand mx-auto" href="index.jsp">
            <div class="texto-blanco" align="center">
                <img src="images/logo.png" width="60" height="45" class="d-inline-block align-top" alt="">  
                <%=ConstantesApp.NAME_FACT%>
                <br>
                <small><p class="mb-0" id="slogan"><%=ConstantesApp.LEYENDA_APP%></p></small>
                <button class="navbar-toggler navbar-toggler-right hidden-sm-up" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar2">
                    &#9776;
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </a>

        <div class="collapse navbar-toggleable-xs" id="exCollapsingNavbar2">
            <ul class="nav navbar-nav pull-xs-right ml-au">
                <%if (rol == 0) {%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Catálogo
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="catalogo1.jsp">Fundas iPhone</a>
                        <a class="dropdown-item" href="catalogo2.jsp">Fundas Android</a>
                        <a class="dropdown-item" href="catalogo3.jsp">Audifonos</a>
                        <a class="dropdown-item" href="catalogo4.jsp">Cargadores</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Usuario
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="login.jsp">Ingresar</a>
                        <a class="dropdown-item" href="register.jsp">Registrarse</a>
                    </div>
                </li><%}%>
                <%if (rol == 1) {%>
                <li class="nav-item"><a class="nav-link" href="catalogousers.jsp">Usuarios</a></li>
                <li class="nav-item"><a class="nav-link" href="catalogoadmin.jsp">Inventario</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Añadir</a></li>
                <li class="nav-item"><a class="nav-link" href="catalopedidos.jsp">Pedidos</a></li>
                <li class="nav-item"><%=logout%></li>
                <%}%> 
                <%if (rol == 2) {%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Catálogo
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="catalogo1.jsp">Fundas iPhone</a>
                        <a class="dropdown-item" href="catalogo2.jsp">Fundas Android</a>
                        <a class="dropdown-item" href="catalogo3.jsp">Audifonos</a>
                        <a class="dropdown-item" href="catalogo4.jsp">Cargadores</a>
                    </div>
                </li>
                <li class="nav-item"><a class="nav-link" href="carrito.jsp">Carrito</a></li>
                <li class="nav-item"><a class="nav-link" href="carrito.jsp">Mis Compras</a></li>
                <li class="nav-item"><%=logout%></li>

                <%}%>
                <%=panelOculto%>
            </ul>
        </div>
    </nav>
</header>

