/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import conexion.Conexion;
import dao.ProductoDAO;
import dto.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author xykukulkan
 */
public class Catalogo extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        try {
            Connection conn = Conexion.getConexionUnica(this.context.getInitParameter("IP"),
            this.context.getInitParameter("BD"), this.context.getInitParameter("USUARIO"),
            this.context.getInitParameter("PASS"));
            int idCategoria = Integer.parseInt(request.getParameter("id"));
            
            List<Producto> listaProductos = new ProductoDAO(conn).getListaProductos(idCategoria);
            PrintWriter out = response.getWriter();

            out.println("<table id='example' class=\"table table-striped\">\n"
                    + "  <thead>\n"
                    + "    <tr>\n"
                    + "      <th>#Producto</th>\n"
                    + "      <th>Nombre Producto</th>\n"
                    + "      <th>Imagen</th>\n"
                    + "      <th>Precio</th>\n"
                    + "      <th>Detalles</th>\n"
                    + "    </tr>\n"
                    + "  </thead>\n"
                    + "  <tbody>\n");
            int i=1;
            for (Iterator<Producto> iterator = listaProductos.iterator(); iterator.hasNext();) {
                Producto next = iterator.next();
                out.println("    <tr>\n"
                        + "      <td>" + i + "</td>\n"
                        + "      <td>" + next.getNombre() + " </td>\n"
                        + "      <td><img src=\"" + next.getImg() + "\" class=\"img-fluid\" alt=\"\" width=\"130\"></td>\n"
                        + "      <td> $" + next.getPrecio() + "</td>\n"
                        + "      <th scope=\"row\"> <a href=\"FrontController?comando=ProductoDetalles&id="+ next.getId() +"\">Ver Mas</a></th>"
                        + "    </tr>\n");
                i++;
            }
            out.println("  </tbody>\n"
                    + "</table>");

        } catch (SQLException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
