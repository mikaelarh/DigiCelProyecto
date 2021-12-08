package comandos;

import comandos.FrontCommand;
import conexion.Conexion;
import conexion.Conexion2;
import dao.Acceso;
import dao.Log;
import dto.DatosLogin;
import dto.LogDTO;
import dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import java.sql.SQLException;

public class Registro extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        try {
            Connection conn = Conexion.getConexionUnica(this.context.getInitParameter("IP"),
                            this.context.getInitParameter("BD"), this.context.getInitParameter("USUARIO"),
                            this.context.getInitParameter("PASS"));
            Connection conn_2 = Conexion2.getConexionUnica(this.context.getInitParameter("IP"),
                            this.context.getInitParameter("BD_2"), this.context.getInitParameter("USUARIO"),
                            this.context.getInitParameter("PASS"));
            
            PrintWriter out = response.getWriter();
            String accion = request.getParameter("peticion");
            Acceso registro = new Acceso(conn);
            String correo = request.getParameter("correo");
            String user = request.getParameter("usuario").toLowerCase();
                    
            LogDTO log = new LogDTO();
            Log logDAO = new Log(conn_2);

            switch (accion) {
            case "alta":

                    Usuario usuario = new Usuario();
                    DatosLogin datos = new DatosLogin();

                    usuario.setNombre(request.getParameter("nombre").toUpperCase());
                    usuario.setApPaterno(request.getParameter("ap_paterno").toUpperCase());
                    usuario.setApMaterno(request.getParameter("ap_materno").toUpperCase());
                    usuario.setCorreo(correo);

                    int idUsuario = registro.registroUsuario(usuario);
                    datos.setIdUsuario(idUsuario);
                    datos.setNombreUsuario(user);
                    datos.setContrasenia(request.getParameter("password"));
                    datos.setIdRol(2);//Integer.parseInt(request.getParameter("rol")));
                    datos.setEstado(1);

                    registro.altaUsuario(datos);
                    usuario.setDatosLogin(datos);

                    request.getSession().setAttribute("usuario", usuario);
                    
                    log.setNombre("ALTA");
                    log.setDescripcion("Alta de Usuario");
                    log.setIdPersona(idUsuario);
               
                    logDAO.registrarAccion(log);
                    
                    this.forward("login");
                    break;
            case "usuario":
                    int validacionUsuario = registro.validarCorreoUsuario(user, 0);
                    System.out.println("user" + validacionUsuario);
                    //response.setContentType("text/html;charset=UTF-8");
                    //response.getWriter().write(validacionUsuario);
                    out.println(validacionUsuario);

                    log.setNombre("USUARIO");
                    log.setDescripcion("Intento de ingreso al sistema");
                    log.setIdPersona(validacionUsuario);
               
                    logDAO.registrarAccion(log);
                    break;

            case "correo":
                    int validacionCorreo = registro.validarCorreoUsuario(correo, 1);
                    System.out.println(validacionCorreo);
                    //response.setContentType("text/html;charset=UTF-8");
                    //response.getWriter().write(validacionCorreo);
                    out.println(validacionCorreo);
                    
                    log.setNombre("CORREO");
                    log.setDescripcion("Validacion de correo electronico Valido");
                    log.setIdPersona(validacionCorreo);
               
                    logDAO.registrarAccion(log);
                    break;
            default:
                    break;
            }
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        
    }

}
