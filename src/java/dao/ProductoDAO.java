/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CtUsers;
import dto.PedidosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dto.Producto;
import dto.Productoadmin;

public class ProductoDAO {
    
    private Connection conexion;
    public ProductoDAO(Connection conn) {
            this.conexion = conn;
    }
    
    
    public List<Producto> getListaProductos(int idCategoria){
        List<Producto> productos = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String QUERY = "SELECT * FROM Productos Where IdCategoria=?;";
        try{
            ps = conexion.prepareStatement(QUERY);
            ps.setInt(1, idCategoria);
            rs = ps.executeQuery();
            while(rs.next()){
                productos.add(new dto.Producto(rs.getInt("IdProducto"), rs.getString("Nombre"), rs.getString("ImgProducto"),
                rs.getInt("IdCategoria"), rs.getDouble("Precio"), rs.getInt("Stock")));
            }
            
            return productos;

        }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    public List<Productoadmin> getListaInventario(){
        List<Productoadmin> productos = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String QUERY = "SELECT * FROM Productos;";
        try{
            ps = conexion.prepareStatement(QUERY);
            rs = ps.executeQuery();
            while(rs.next()){
                productos.add(new dto.Productoadmin(rs.getInt("IdProducto"), rs.getString("Nombre"), rs.getString("ImgProducto"),
                rs.getInt("IdCategoria"), rs.getDouble("Precio"), rs.getInt("Stock")));
            }
            
            return productos;

        }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }
    
    public List<CtUsers> getListaUsuarios(){
        List<CtUsers> personas = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String QUERY = "SELECT * FROM Personas;";
        try{
            ps = conexion.prepareStatement(QUERY);
            rs = ps.executeQuery();
            while(rs.next()){
                personas.add(new dto.CtUsers(rs.getInt("IdPersona"), rs.getString("Nombre"), rs.getString("ApellidoPaterno"),
                rs.getString("ApellidoMaterno"), rs.getString("Correo")));
            }
            
            return personas;

        }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }
    
        public List<PedidosDTO> getListaPedidos(){
        List<PedidosDTO> pedidos = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String QUERY = "SELECT `IdPedido`, personas.Nombre,productos.Nombre,estadospedidos.Descripcion,`Cantidad`,`FechaPedido` FROM `pedidos`\n" +
"INNER JOIN personas ON pedidos.IdPersona=personas.IdPersona\n" +
"INNER JOIN productos ON pedidos.IdProducto=productos.IdProducto\n" +
"INNER JOIN estadospedidos ON pedidos.IdEstado=estadospedidos.IdEstado";
        try{
            ps = conexion.prepareStatement(QUERY);
            rs = ps.executeQuery();
            while(rs.next()){
                pedidos.add(new dto.PedidosDTO(rs.getInt("IdPedido"), rs.getString("personas.Nombre"), rs.getString("productos.Nombre"),
                rs.getString("estadospedidos.Descripcion"), rs.getInt("Cantidad"), rs.getString("FechaPedido")));
            }            
            return pedidos;
        }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }
    
    public Producto getProducto(int idProducto){
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String QUERY = "SELECT * FROM Productos WHERE IdProducto=?;";
        try{
            ps = conexion.prepareStatement(QUERY);
            ps.setInt(1, idProducto);
            rs = ps.executeQuery();
            if(rs.next()){
                return (new dto.Producto(rs.getInt("IdProducto"), rs.getString("Nombre"), rs.getString("ImgProducto"),
                rs.getInt("IdCategoria"), rs.getDouble("Precio"), rs.getInt("Stock")));
            }
            return null;
        }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }
    
    public Productoadmin getInventario(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String QUERY = "SELECT * FROM Productos;";
        try{
            ps = conexion.prepareStatement(QUERY);
            rs = ps.executeQuery();
            if(rs.next()){
                return (new dto.Productoadmin(rs.getInt("IdProducto"), rs.getString("Nombre"), rs.getString("ImgProducto"),
                rs.getInt("IdCategoria"), rs.getDouble("Precio"), rs.getInt("Stock")));
            }
            return null;
        }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }
    
    public CtUsers getUsers(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String QUERY = "SELECT * FROM Productos;";
        try{
            ps = conexion.prepareStatement(QUERY);
            rs = ps.executeQuery();
            if(rs.next()){
                return (new dto.CtUsers(rs.getInt("IdPersona"), rs.getString("Nombre"), rs.getString("ApellidoPaterno"),
                rs.getString("ApellidoMaterno"), rs.getString("Correo")));
            }
            return null;
        }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }
        public PedidosDTO getPedidos(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        final String QUERY = "SELECT `IdPedido`, personas.Nombre,productos.Nombre,estadospedidos.Descripcion,`Cantidad`,`FechaPedido` FROM `pedidos`\n" +
"INNER JOIN personas ON pedidos.IdPersona=personas.IdPersona\n" +
"INNER JOIN productos ON pedidos.IdProducto=productos.IdProducto\n" +
"INNER JOIN estadospedidos ON pedidos.IdEstado=estadospedidos.IdEstado";
        try{
            ps = conexion.prepareStatement(QUERY);
            rs = ps.executeQuery();
            if(rs.next()){
                return(new dto.PedidosDTO(rs.getInt("IdPedido"), rs.getString("personas.Nombre"), rs.getString("productos.Nombre"),
                rs.getString("estadospedidos.Descripcion"), rs.getInt("Cantidad"), rs.getString("FechaPedido")));
            }
            return null;
        }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }
}
