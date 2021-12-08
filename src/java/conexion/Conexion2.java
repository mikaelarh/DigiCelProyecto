package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion2 {
	private static Connection conexionUnica;
	private Conexion2(String direccionIp, String nombreBD, 
			String usuarioBD, String passwordBD) throws SQLException{
		cargarControlador();
		//obtener la conexion		
		String url = "jdbc:mysql://localhost:3306/logdatabase?autoreconnect=true";
		
		conexionUnica = DriverManager.getConnection(url,"root","");
	}
	
	private void cargarControlador() throws SQLException{		
			DriverManager.registerDriver (new com.mysql.jdbc.Driver());		
	}	
	
	public static Connection getConexionUnica(String direccionIp, 
			String nombreBD, String usuarioBD, String passwordBD) throws SQLException{
		
		if(conexionUnica == null){
			new Conexion2("localhost:3306", "microstore", "root", "");			
		}
		System.out.println("Te doy la conexion");
		return conexionUnica;
	} 
        
        
}

