package dto;

public class Usuario {

	private int id_usuario;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String correo;
	private DatosLogin datosLogin;
	private String foto;
	
	public Usuario() {

	}

	public int getIdUsuario() {
		return id_usuario;
	}

	public void setIdUsuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setDatosLogin(DatosLogin datosLogin) {
		this.datosLogin = datosLogin;
	}
	
	public DatosLogin getDatosLogin() {
		return datosLogin;
	}

        @Override
	public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(this.apPaterno);             
            sb.append(" ");
            sb.append(this.apMaterno);
            sb.append(" ");
            sb.append(this.nombre);
            return sb.toString().toUpperCase();
        }

}
