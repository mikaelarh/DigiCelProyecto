/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import conexion.Conexion;
import dao.ProductoDAO;
import dto.Productoadmin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
public class CatalogoAdmin extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        try {
            Connection conn = Conexion.getConexionUnica(this.context.getInitParameter("IP"),
            this.context.getInitParameter("BD"), this.context.getInitParameter("USUARIO"),
            this.context.getInitParameter("PASS"));
            
            List<Productoadmin> listaInventario = new ProductoDAO(conn).getListaInventario();
            PrintWriter out = response.getWriter();

            out.println("<table id='example' class=\"table table-striped\">\n"
                    + "  <thead>\n"
                    + "    <tr>\n"
                    + "      <th>#Producto</th>\n"
                    + "      <th>Nombre Producto</th>\n"
                    + "      <th>Imagen</th>\n"
                    + "      <th>Precio</th>\n"
                    + "      <th>Stock</th>\n"
                    + "      <th>Editar</th>\n"
                    + "    </tr>\n"
                    + "  </thead>\n"
                    + "  <tbody>\n");
            int i=1;
            for (Iterator<Productoadmin> iterator = listaInventario.iterator(); iterator.hasNext();) {
                Productoadmin next = iterator.next();
                out.println("    <tr>\n"
                        + "      <td>" + i + "</td>\n"
                        + "      <td>" + next.getNombre() + " </td>\n"
                        + "      <td><img src=\"" + next.getImg() + "\" class=\"img-fluid\" alt=\"\" width=\"130\"></td>\n"
                        + "      <td> $" + next.getPrecio() + "</td>\n"
                                + "      <td> " + next.getStock() + "</td>\n"
                        + "      <th scope=\"row\"> <a href=\"FrontController?comando=ProductoEditar&id="+ next.getId() +"\">Editar</a></th>"
                        + "    </tr>\n");
                i++;
            }
            out.println("  </tbody>\n"
                    + "</table>");

        } catch (SQLException ex) {
            Logger.getLogger(CatalogoAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
