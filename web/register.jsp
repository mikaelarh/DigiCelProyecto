<%-- 
    Document   : register
    Created on : 29/11/2017, 04:09:11 PM
    Author     : xykukulkan
--%>
<%@page import="core.ConstantesApp"%>

<!DOCTYPE html>
<html lang="en">
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
  
  <!-- Body ================================================== -->
  <body class="preview" data-spy="scroll" data-target=".subnav" data-offset="80">
    <br>
    <!-- Contenido ================================================== -->
    <div class="container">
      <section id="typography">

        <div class="row align-items-center">     
          <div class="container">



            <div class="center-div card card-login mx-auto mt-5" style="max-width: 40rem;">
              <div class="card-header">
                <h4 align="center"><strong>Crear Cuenta</strong></h4>
              </div>
              
              <div class="card-block">
                <form id="datos" action="FrontController?comando=Registro" method="POST">
                  <div class="form-group">
                    <input name="peticion" value="alta" type="hidden"> <input
					name="rol" value="2" type="hidden">
                    <div class="form-group col-md-12">
                        <label for="exampleInputName" >Nombre Completo</label>
                        <input class="form-control" id="nombre" name="nombre" type="text" aria-describedby="nombreHelp" placeholder="Enter name">
                  </div>
                    <div class="form-group col-md-6">
                      <label for="ap_paterno">Apellido Paterno</label>
                      <input class="form-control" id="ap_paterno" name="ap_paterno" type="text" aria-describedby="paternoHelp" placeholder="Enter last name">
                    </div>

                  </div>
                  <div class="form-group col-md-6">
                    <div>
                      <label for="ap_materno">Apellido Materno</label>
                      <input class="form-control" id="ap_materno" name="ap_materno" type="text" aria-describedby="maternoHelp" placeholder="Enter last name">
                    </div>
                  </div>
                    <div class="form-group col-md-12">
                      <label for="correo">Correo Electronico</label>
                      <input class="form-control" id="correo" name="correo" type="email" aria-describedby="emailHelp" placeholder="Enter email">
                      <small id="emailHelp" class="form-text text-muted">Nunca compartiremos su correo con nadie mas.</small>
                      <span id="correo_actual" hidden=""></span>
                      <div id="info" class="red-text"></div>
                      <span id="flag" hidden=""></span>
                    </div>

                    <div class="form-group col-md-12">
                      <div class="input-group-addon">@Usuario</div>
                      <input class="form-control" id="usuario" name="usuario" type="text" aria-describedby="userHelp" placeholder="Username">
                      <span id="validacion_usuario" hidden=""></span>
                      <div id="info_usuario" class="" ></div>
                    </div>

                  <div class="form-group col-md-6">
                        <div class="">
                          <label for="password">Contraseña</label>
                          <input class="form-control" id="password" name="password" type="password" placeholder="Password">  
                        </div>
                  </div>
                        

                  <div class="form-group col-md-6">
                        <div class="">
                          <label for="confirmarpass">Confirmar Contraseña</label>
                          <input class="form-control" id="confirmarpass" type="password" placeholder="Confirm password">
                        </div>
                  </div>
                          
                  <div class="col-md-12">
                    <button type="submit" class="btn btn-primary btn-block" id="btn_enviar">Registrar</button>
                  </div>
                  <div align="center">
                    <small class="form-text text-muted"><a href="login.jsp">Pagina de Login</a></small>
                    <div class="row">
                      <h6 id="aviso" style="color: red"></h6>
                    </div>
                  </div>
                </form>
              </div>

            </div>
          </div>
  
        </div>
      
      </section>
    </div>
      
    <br>
    <!-- /container -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/registro.js"></script>
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


</html>