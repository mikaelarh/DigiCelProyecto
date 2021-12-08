
package comandos;

import conexion.Conexion;
import dao.Acceso;
import dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
/**
 *  DISPATCHER - Login.java
 * @author xykukulkan
 */
public class Login extends FrontCommand {


    @Override
    public void process() throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Connection conn = Conexion.getConexionUnica
        (this.context.getInitParameter("IP"),
            this.context.getInitParameter("BD"), 
            this.context.getInitParameter("USUARIO"),
            this.context.getInitParameter("PASS"));

            Acceso acceso = new Acceso(conn);
            Usuario usuario = acceso.Login(request.getParameter("usuario")
                    .toLowerCase(), request.getParameter("password"));
            System.out.println(usuario.getDatosLogin().getIdUsuario() + "\n" 
                    + usuario.getNombre());
        
            PrintWriter out = response.getWriter();

            if (usuario.getDatosLogin().getIdUsuario() != 0) {
		request.getSession().setAttribute("usuario", usuario);
                //String target = String.format("/%s.jsp", "index");
		switch (usuario.getDatosLogin().getIdRol()) {
                    
		case 1:
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().write("true");
                    response.setIntHeader("Refresh",1);

                   
		break;
		case 2:
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().write("true");
                    response.setIntHeader("Refresh",1);

		break;
		}
            } else {
		request.getSession().setAttribute
        ("estado", "Datos incorrectos");
                out.print("false");
                
                //this.forward("login");
                //response.sendRedirect("login.jsp#");
            }

	} catch (SQLException e) {
            e.printStackTrace();
	}
    }

}
