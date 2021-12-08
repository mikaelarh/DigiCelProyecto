/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import conexion.Conexion;
import dao.ProductoDAO;
import dto.CtUsers;
import dto.PedidosDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
public class CatalogoPedidos extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        try {
            Connection conn = Conexion.getConexionUnica(this.context.getInitParameter("IP"),
            this.context.getInitParameter("BD"), this.context.getInitParameter("USUARIO"),
            this.context.getInitParameter("PASS"));
            
            List<PedidosDTO> listaPedidos = new ProductoDAO(conn).getListaPedidos();
            PrintWriter out = response.getWriter();

            out.println("<table id='example' class=\"table table-striped\">\n"
                    + "  <thead>\n"
                    + "    <tr>\n"
                    + "      <th>#</th>\n"
                    + "      <th>Persona</th>\n"
                    + "      <th>Producto</th>\n"
                    + "      <th>Estado</th>\n"
                    + "      <th>Cantidad</th>\n"
                    + "      <th>Fecha</th>\n"
                    + "    </tr>\n"
                    + "  </thead>\n"
                    + "  <tbody>\n");
            int i=1;
            for (Iterator<PedidosDTO> iterator = listaPedidos.iterator(); iterator.hasNext();) {
                PedidosDTO next = iterator.next();
                out.println("    <tr>\n"
                        + "      <td>" + next.getId() + "</td>\n"
                        + "      <td>" + next.getNombre() + " </td>\n"
                        + "      <td>" + next.getNombrep()+ "</td>\n"
                        + "      <td> " + next.getEstado() + "</td>\n"
                        + "      <td> " + next.getCantidad() + "</td>\n"
                        + "      <td> " + next.getFecha() + "</td>\n"
                        + "    </tr>\n");
                i++;
            }
            out.println("  </tbody>\n"
                    + "</table>");

        } catch (SQLException ex) {
            Logger.getLogger(CatalogoPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
