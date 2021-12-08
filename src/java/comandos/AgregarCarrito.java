/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import conexion.Conexion;
import dao.ProductoDAO;
import dto.Articulo;
import dto.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xykukulkan
 */
public class AgregarCarrito extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(true);
        if(sesion.getAttribute("usuario") != null){
            ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");
            //HACER VALIDACION, SI REGISTRADO ENTONCES AGREGAR SI NO ENTONCES MOSTRAR LOGIN
            Articulo articulo = new Articulo();
            System.out.println("VALOR ARTICULOS : " + sesion.getAttribute("articulo"));    
            Producto producto = (Producto)sesion.getAttribute("articulo");
            articulo.setProducto(producto);
            articulo.setCantidad(1);
            articulos.add(articulo);
            sesion.setAttribute("carrito", articulos);
            this.forward("carrito"); 
        }else{
            PrintWriter out = response.getWriter();
            this.forward("login");
            request.getSession().setAttribute("estado", "Inicie sesión para realizar sus compras");
            out.print("false");
//response.sendRedirect(request.getRequestURL().toString());

        }
    }
    
}
