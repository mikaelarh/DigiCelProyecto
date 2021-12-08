package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import dto.DatosLogin;
import dto.Usuario;

public class Acceso {

	private Connection conexion;
	public Acceso(Connection conn) {
		this.conexion = conn;
	}

	public Usuario Login(String usuario, String contrasenia) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario datosUsuario = new Usuario();
		DatosLogin datosLogin = new DatosLogin();

		final String QUERY = "SELECT T1.Nombre, T1.ApellidoPaterno, "
                        + "T1.ApellidoMaterno, T1.Correo, \r\n"
				+ "T3.Nombre, T2.IdPersona, T3.IdRol "
                        + "FROM personas AS T1\r\n"
				+ "     INNER JOIN accesos AS T2\r\n" 
                        + "	 ON T1.IdPersona = T2.IdPersona\r\n"
				+ "     INNER JOIN roles AS T3\r\n" 
                        + "     ON T2.IdRol = T3.IdRol\r\n"
				+ "     WHERE T2.Username =?\r\n" 
                        + "     AND T2.Password =? ;";

		try {
			ps = conexion.prepareStatement(QUERY);
			ps.setString(1, usuario);
			ps.setString(2, contrasenia);
			rs = ps.executeQuery();

			if (rs.next()) {
				datosUsuario.setNombre(rs.getString(1));
				datosUsuario.setApPaterno(rs.getString(2));
				datosUsuario.setApMaterno(rs.getString(3));
				datosUsuario.setCorreo(rs.getString(4));
				datosLogin.setRol(rs.getString(5));
				datosLogin.setIdUsuario(rs.getInt(6));
				datosLogin.setContrasenia(contrasenia);
				datosLogin.setNombreUsuario(usuario);
				datosLogin.setIdRol(rs.getInt(7));
				datosLogin.setEstado(1);
			}
			datosUsuario.setDatosLogin(datosLogin);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datosUsuario;

	}

	public int registroUsuario(Usuario usuario) {

		PreparedStatement prepare = null;
		ResultSet rs = null;
		int idUusario = 0;

		final String q = "INSERT INTO personas\r\n" 
                        + "(Nombre, ApellidoPaterno,\r\n"
				+ "ApellidoMaterno, Correo)\r\n" 
                        + "VALUES\r\n" + "(?, ?, ?, ?);";
		try {
			prepare = conexion.prepareStatement
        (q, PreparedStatement.RETURN_GENERATED_KEYS);
			prepare.setString(1, usuario.getNombre());
			prepare.setString(2, usuario.getApPaterno());
			prepare.setString(3, usuario.getApMaterno());
			prepare.setString(4, usuario.getCorreo());
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

	public boolean altaUsuario(DatosLogin datos) {

		PreparedStatement prepare = null;
		final String q = "INSERT INTO accesos (Username, "
                        + "Password, IdRol, IdPersona, Estado) "
                        + "VALUES (?, ?, ?, ?, ?);";

		try {
			prepare = conexion.prepareStatement(q);
			prepare.setString(1, datos.getNombreUsuario());
			prepare.setString(2, datos.getContrasenia());
			prepare.setInt(3, datos.getIdRol());
			prepare.setInt(4, datos.getIdUsuario());
                        prepare.setInt(5, 1);
			prepare.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public int validarCorreoUsuario(String dato, int opcion) {
		PreparedStatement ps = null;
		ResultSet res = null;
		int tam = 0;
		String query = "";
		if (opcion == 1) {
			query = "SELECT Correo\r\n" + "FROM personas\r\n" 
                                + "WHERE Correo = ?;";
		} else {
			query = "SELECT Username\r\n" + "FROM accesos\r\n" 
                                + "WHERE Username = ?;";
		}

		try {
			ps = conexion.prepareStatement(query);
			ps.setString(1, dato);
			res = ps.executeQuery();

			if (res.next()) {
				tam = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tam;
	}

}
