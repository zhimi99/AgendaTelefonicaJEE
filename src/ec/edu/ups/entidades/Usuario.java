package ec.edu.ups.entidades;

import java.io.Serializable;

public class Usuario  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int id;
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String clave;
	
	
	public Usuario() {
		super();
		
	}
	
	public Usuario(int id, String cedula, String nombre, String apellido, String correo, String clave) {
		
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.clave = clave;
	}
	 
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
		
}
