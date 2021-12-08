<%@page import="dto.Usuario"%>
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
  <body class="preview" data-spy="scroll" data-target=".subnav" 
        data-offset="80">
    
    <br><br>
    <!-- Contenido ================================================== -->
    <div class="container">
      <section id="typography">
        <div class="row align-items-center">     
          <div class="container">
            <div class="center-div card card-login mx-auto mt-5" 
                 style="max-width: 30rem;">
              <div class="card-header">
                <h4 align="center"><strong>Login</strong></h4>
              </div>
              <div class="card-block">
              
              <%if(usuario == null) { %>
                <form method="POST" id="datos" action="#">
                  <div class="form-group">
                    <label for="usuario">Usuario</label>
                    <input class="form-control" id="usuario" name="usuario" 
                           type="text" aria-describedby="emailHelp" 
                           placeholder="Ingrese cuenta">
                  </div>
                  <div class="form-group">
                    <label for="password">Contraseña</label>
                    <input class="form-control" id="password" name="password" 
                           type="password" placeholder="Password">
                  </div>
                  <button  class="btn btn-primary btn-block" type="submit" 
                           id="btn_enviar">Login</button>
                </form>
                <div class="text-center">
                    <span id="estado"  style="color:red" ></span>
                  <a class="d-block small mt-3" href="register.jsp">
                      Registrar una cuenta</a>
                </div>
              <%}else {%>
                <form method="POST" action="FrontController?comando=Logout">
                    <div class="form-group col-md-12">
                        <h3><b>Actualmente se encuentra logueado como : </b>
                        </h3>
                    </div>
                    <div class="form-group col-md-12">
                      <div class="input-group-addon">@Usuario</div>
                      <input class="form-control" aria-describedby="userHelp" 
                             placeholder="Username" value="<%=usuario%>" 
                             disabled>
                    </div>
                    <div class="form-group col-md-12">
                        <button type="submit" class="btn btn-primary btn-block"
                                href="#">Log Out</button>
                    </div>
                </form>
                <div class="text-center" align="center">
                  <a class="d-block small mt-3" href="index.jsp">Ir a Principal
                  </a>
                </div>
              <%}%>
                
              </div>
            </div>
          </div>
  
        </div>
      
      </section>
    </div>
    <br>
    <br>
    <!-- /container -->
    
    <!-- footer -->
    <footer class="footer bg-dark texto-blanco">
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
    <script type="text/javascript">
        $(document).ready(function() {
             
            $('#btn_enviar').click(function(e) {
		e.preventDefault();
             
                    if(validar()){
                         $.ajax({
                        type: "POST",
                        url: "FrontController",
                        data: $("#datos").serialize() + "&comando=Login",
                        success: function (data) {
                            if(data == 'false'){
                                $('#estado').html("<p class='d-block small \n\
                    mt-3'>Credenciales incorrectas</p>");
                            }else{
                              document.location.reload(true);  
                            }
                        }
                    });
                }else{
                    $('#estado').html("<p class='d-block small mt-3'>\n\
        Favor de llenar todos los campos</p>");
                }
            });
        });
            
           
        
        function validar(){
            if(($('#usuario').val() && $('#password').val()).length != 0){
                return true;
            }
            return false;
        }
    </script>

  </body>
</html>
