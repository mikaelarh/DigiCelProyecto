package dto;

public class DatosLogin {

	private int id_usuario;
	private String nombreUsuario;
	private String contrasenia;
	private int idRol;
	private String rol;
	private int estado;
	
	public DatosLogin() {
		
	}

	public int getIdUsuario() {
		return id_usuario;
	}

	public void setIdUsuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public void setIdRol(int IdRol) {
		this.idRol = IdRol;
	}
	
	public int getIdRol() {
		return idRol;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public int getEstado() {
		return estado;
	}

}
