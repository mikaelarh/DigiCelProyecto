/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import dto.Articulo;
import dto.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xykukulkan
 */
public class MostrarCarrito extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        this.generarTablaCarrito();
    }
    
    private void generarTablaCarrito() throws IOException{
        HttpSession sesion = request.getSession(true);
        List<Articulo> articulos = (ArrayList<Articulo>)sesion.getAttribute("carrito");
        PrintWriter out = response.getWriter();

        if(articulos != null){
            out.println("<table id='example' class=\"table table-striped\">\n"
                    + "  <thead>\n"
                    + "    <tr>\n"
                    + "      <th>#Producto</th>\n"
                    + "      <th>Nombre Producto</th>\n"
                    + "      <th>Imagen</th>\n"
                    + "      <th>Precio</th>\n"
                    + "      <th>Cantidad</th>\n"
                    + "      <th>Comprar</th>\n"
                    + "      <th>Quitar</th>\n"
                    + "    </tr>\n"
                    + "  </thead>\n"
                    + "  <tbody>\n");
            Producto producto = null;
            for (Iterator<Articulo> iterator = articulos.iterator(); iterator.hasNext();) {
                Articulo next = iterator.next();
                producto = next.getProducto();
                out.println("    <tr>\n"
                        + "      <td>" + producto.getId() + "</td>\n"
                        + "      <td>" + producto.getNombre() + " </td>\n"
                        + "      <td><img src=\"" + producto.getImg() + "\" class=\"img-fluid\" alt=\"\" width=\"130\"></td>\n"
                        + "      <td> $" + producto.getPrecio() + "</td>\n"
                        + "      <td>"+next.getCantidad()+"</td>\n"
                        + "      <td> <div>\n   <form > \n" +
"            <input type=\"button\" value=\"Completar Compra\">\n" +
"    </form> </div> </td>\n");
            }
            out.println("  </tbody>\n"
                    + "</table>");
            
        }else{
            out.println("<h3>No tiene articulos en su carrito</h3>");
        }
        
    }
    
}
