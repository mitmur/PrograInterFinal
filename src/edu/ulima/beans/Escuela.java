package edu.ulima.beans;

public class Escuela {

	private int id;
	private String nombre;
	private int codigo;
	
	public Escuela() {
	}

	public Escuela(int id, String nombre, int codigo) {
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Escuela [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}
	
	
}
