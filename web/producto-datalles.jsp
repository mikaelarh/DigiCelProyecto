<%-- 
    Document   : producto-datalles
    Created on : 7/02/2018, 08:39:57 AM
    Author     : xykukulkan
--%>

<%@page import="dto.Producto"%>
<%//Valida que este usuario logeado%>
<%@page import="core.ConstantesApp"%>
<%@page import="core.ConstantesApp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Producto producto = (Producto)request.getAttribute("articulo");
%>

<!DOCTYPE html>
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
    
    <body class="preview" data-spy="scroll" data-target=".subnav" data-offset="80">
    
    <br><br>
    <!-- Contenido ================================================== -->
    <div class="container">
        <section id="typography">
        <div class="row align-items-center">     
          <div class="container">
            <div class="center-div card card-login mx-auto mt-5" style="max-width: 30rem;">
              <div class="card-header">
                <h4 align="center"><strong>ARTICULO DEL CATALOGO</strong></h4>
              </div>
              <div class="card-block">
              <%if(producto != null){%>
                <form method="POST" action="FrontController?comando=AgregarCarrito">
                    <%request.setAttribute("articulo", producto);%>
                    <div class="form-group">
                        <input id="prodId" name="prodId" type="hidden" value="<%= producto.getId() %>">
                        <img src=<%=producto.getImg()%> class="img-fluid" alt="" width="500">
                        <b>Nombre de Producto : </b> <%= producto.getNombre() %>
                        <br><b>Precio : </b> $<%= producto.getPrecio()%>
                        <br><b>Stock : </b> <%= producto.getStock()%> Unidades
                    </div>
                    <div class="form-group col-md-12">
                        <button type="submit" class="btn btn-primary btn-block">Comprar</button>
                    </div>
                </form>
              <%}else {%>
                <form method="POST" action="FrontController?comando=AgregarCarrito">
                    <div class="form-group">
                        <b><h4>El Articulo de desea comprar no se encuentra disponible.</h4></b>
                    </div>
                  
                </form>
              <%}%>
                
              </div>
            </div>
          </div>
  
        </div>
      
      </section>
        
      <section id="typography">
        <div class="row align-items-center" id="productos">     
        </div>
      </section>
    </div>
    <br>
    <br>
    <!-- /container -->
    </body>
          
    <!-- footer -->
    <footer>
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-12">
            <p>&copy; <%=ConstantesApp.INFO_FOOTER%></p>
          </div>
        </div>
      </div>
    </footer>
    <!-- End footer -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    <script src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js" type="text/javascript"></script>
   
</html>

