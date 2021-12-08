<%@page import="core.ConstantesApp"%>
<%@page import="core.ConstantesApp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <head>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title><%=ConstantesApp.NAME_APP%></title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
  </head>

  <!-- Header/Navigation --> 
  <%@include file="WEB-INF/jspf/headerPrincipal.jsp" %> 
  <!-- /End of Header/Navigation -->


  <body>
<!-- Carouser/Slider -->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
  </ol>
  
  <div class="carousel-inner" role="listbox">
    <div class="carousel-item active">
      <img src="images/slider1.jpg" alt="First slide">
    </div>
    <div class="carousel-item">
      <img src="images/slider2.jpg" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img src="images/slider3.jpg" alt="Third slide">
    </div>
    <div class="carousel-item">
      <img src="images/slider4.jpg" alt="Fourt slide">
    </div>
  </div>
</div>

<!-- /End of Carousel/Slider -->

<!-- Card -->
    <div class="container-fluid">
    <div class="row services">
      <div class="col-md-4">
        <div class="card card-block">
          <h3 class="card-title"><b>Fundas</b></h3>
          <p class="card-text">CONTAMOS CON UNA GRAN VARIEDAD DE FUNDAS PARA
              EQUIPOS ACTUALES DE LOS MEJORES ESTILOS DEL MERCADO. 
              </p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card card-block">
          <h3 class="card-title"><b>Accesorios</b></h3>
          <p class="card-text">CONTAMOS CON GRAN VARIEDAD DE ACCESORIOS
              PARA TU CELULAR, YA SEA ANDROID E IOS.</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card card-block">
          <h3 class="card-title"><b>Sobre Nosotros</b></h3>
          <p class="card-text">SOMOS UNA TIENDA MINORISTA 100%
              CAMPECHANA, CONTAMOS CON GRAN VARTIEDAD DE PRODUCTOS
              Y ACCESORIOS, PARA UNA MEJOR COMUNICACION PUEDE
              ENVIARNOS UN WHATSAPP AL NUMERO 981-197-9001.</p>
        </div>
      </div>
    </div>
    </div>
<!-- /End of card -->

  <!-- footer -->
  <footer class="bg-dark texto-blanco">
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-12">
          <p>&copy; <%=ConstantesApp.INFO_FOOTER%> </p>
        </div>
      </div>
    </div>
  </footer>

    <!-- jQuery first, then Bootstrap JS. -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  
<!-- /End of card -->

  </body>
</html>