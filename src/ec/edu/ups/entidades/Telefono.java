package ec.edu.ups.entidades;

import java.io.Serializable;

public class Telefono implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String numero;
	private String tipo;
	private String operadora;
	private Usuario usuCedula;
	
	public Telefono() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Telefono(int codigo, String numero, String tipo, String operadora,Usuario usuCedula) {
	
		this.codigo = codigo;
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
		this.usuCedula  = usuCedula;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public Usuario getUsuCedula() {
		return usuCedula;
	}
	public void setUsuCedula(Usuario usuCedula) {
		this.usuCedula = usuCedula;
	}
	
}
  