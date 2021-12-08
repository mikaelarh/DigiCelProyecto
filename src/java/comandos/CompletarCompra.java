/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import conexion.Conexion;
import dao.PedidosDAO;
import dto.Articulo;
import dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class CompletarCompra extends FrontCommand {
    
    @Override
    public void process() throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = Conexion.getConexionUnica(this.context.getInitParameter("IP"),
                    this.context.getInitParameter("BD"), this.context.getInitParameter("USUARIO"),
                    this.context.getInitParameter("PASS"));
        } catch (SQLException ex) {
            Logger.getLogger(CompletarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(true);
        PrintWriter out = response.getWriter();

        if(sesion.getAttribute("usuario") != null){
            ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");
            //HACER VALIDACION, SI REGISTRADO ENTONCES AGREGAR SI NO ENTONCES MOSTRAR LOGIN
            Usuario usuario = (Usuario)sesion.getAttribute("usuario");
            System.out.println("USUARIO : " + usuario.getNombre());
            System.out.println("PEROO : " + usuario.getDatosLogin().getIdUsuario());

            if(articulos.size() > 0){
                if(new PedidosDAO(conn).insertPedido(articulos, usuario.getDatosLogin().getIdUsuario())){
                    sesion.setAttribute("carrito", null);
                    //this.forward("carrito");
                    out.print("true");
                    return;
                }
            }
            out.println("Problema");
        }
    }
}