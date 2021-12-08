/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import conexion.Conexion;
import dao.ProductoDAO;
import dto.CtUsers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
public class CatalogoUsers extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        try {
            Connection conn = Conexion.getConexionUnica(this.context.getInitParameter("IP"),
            this.context.getInitParameter("BD"), this.context.getInitParameter("USUARIO"),
            this.context.getInitParameter("PASS"));
            
            List<CtUsers> listaUsers = new ProductoDAO(conn).getListaUsuarios();
            PrintWriter out = response.getWriter();

            out.println("<table id='example' class=\"table table-striped\">\n"
                    + "  <thead>\n"
                    + "    <tr>\n"
                    + "      <th>#</th>\n"
                    + "      <th>Nombre</th>\n"
                    + "      <th>ApellidoP</th>\n"
                    + "      <th>ApellidoM</th>\n"
                    + "      <th>Email</th>\n"
                    + "    </tr>\n"
                    + "  </thead>\n"
                    + "  <tbody>\n");
            int i=1;
            for (Iterator<CtUsers> iterator = listaUsers.iterator(); iterator.hasNext();) {
                CtUsers next = iterator.next();
                out.println("    <tr>\n"
                        + "      <td>" + next.getId() + "</td>\n"
                        + "      <td>" + next.getNombre() + " </td>\n"
                        + "      <td>" + next.getApp()+ "</td>\n"
                        + "      <td> " + next.getApm() + "</td>\n"
                                + "      <td> " + next.getCorreo() + "</td>\n"
                        + "    </tr>\n");
                i++;
            }
            out.println("  </tbody>\n"
                    + "</table>");

        } catch (SQLException ex) {
            Logger.getLogger(CatalogoUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
