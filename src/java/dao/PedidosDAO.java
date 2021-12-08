/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Articulo;
import dto.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PedidosDAO {
    private Connection conexion;
    public PedidosDAO(Connection conn) {
            this.conexion = conn;
    }

    public PedidosDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean insertPedido(List<Articulo> pedidos, int idPersona){
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String QUERY = "insert into Pedidos values(null, ?, ?, 1, ?, CURDATE());";
        final String QUERY2 = "UPDATE `productos` SET `Stock`=productos.Stock-1 WHERE `IdProducto`=?";
        try{
            ps = conexion.prepareStatement(QUERY);
            ps.setInt(1, idPersona);
            System.out.println("ID PERSONAS : " + idPersona);
            for(Articulo articulo : pedidos){
                ps.setInt(2, articulo.getProducto().getId());
                ps.setInt(3, articulo.getCantidad());
                ps.executeUpdate();
            }
            
            return true;
        }catch(SQLException e){
                e.printStackTrace();
        }
        try{
            ps = conexion.prepareStatement(QUERY2);
            for(Articulo articulo : pedidos){
                ps.setInt(1, articulo.getProducto().getId());
                ps.executeUpdate();
            }
            
            return true;
        }catch(SQLException e){
                e.printStackTrace();
        }
        return false;
    }

}
