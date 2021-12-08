<%@page import="core.ConstantesApp"%>
<%@page import="core.ConstantesApp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="row align-items-center" id="productos">     
          
  
        </div>
      </section>
    </div>
    <br>
    <br>
    <!-- /container -->
    </body>
          
    <!-- footer -->
    <footer class="bg-dark texto-blanco">
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
    <script>
        $(document).ready(function () {
            $.ajax({
                type: "POST",
                url: "FrontController?comando=CatalogoAdmin",
                success: function (data) {
                    $('#productos').html(data);
                }
            });
        });

    </script>
</html>
