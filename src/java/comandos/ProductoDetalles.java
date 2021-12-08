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
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xykukulkan
 */
public class ProductoDetalles extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        
        int idArticulo = Integer.parseInt(request.getParameter("id"));
        HttpSession sesion = request.getSession(true);

        System.out.println("IdARTICULO : " + idArticulo);
        Connection conn;
        try {
            conn = Conexion.getConexionUnica(this.context.getInitParameter("IP"),
                    this.context.getInitParameter("BD"), this.context.getInitParameter("USUARIO"),
                    this.context.getInitParameter("PASS"));
            Producto producto = new ProductoDAO(conn).getProducto(idArticulo);
            this.request.setAttribute("articulo", producto);  
            sesion.setAttribute("articulo", producto);
            this.forward("producto-datalles");
        }catch(SQLException e){
            response.sendRedirect(request.getRequestURL().toString());
            e.printStackTrace();
        }
    }
    
}
