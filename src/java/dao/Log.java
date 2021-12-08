/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.LogDTO;
import dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author xykukulkan
 */
public class Log {
    private Connection conexion;
	
    public Log(Connection conn) {
	this.conexion = conn;
    }
    
    public int registrarAccion(LogDTO log) {

		PreparedStatement prepare = null;
		ResultSet rs = null;
		int idUusario = 0;

		final String q = "INSERT INTO Log\r\n" 
                        + "(null, Nombre,\r\n"
				+ "Descripcion, IdPersona)\r\n" 
                        + "VALUES\r\n" + "(?, ?, ?);";
		try {
			prepare = conexion.prepareStatement
                        (q, PreparedStatement.RETURN_GENERATED_KEYS);
			prepare.setString(1, log.getNombre());
			prepare.setString(2, log.getDescripcion());
			prepare.setInt(3, log.getIdPersona());
			prepare.executeUpdate();
			rs = prepare.getGeneratedKeys();

			if (rs.next()) {
				idUusario = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idUusario;
	}


}
