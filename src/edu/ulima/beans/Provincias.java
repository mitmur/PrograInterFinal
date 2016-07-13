package edu.ulima.beans;


public class Provincias {
	
	
	private int id;
	private int id_departamento;
	private String nombre;
	
	
	public Provincias() {
		super();
	}


	public Provincias(int id, int id_departamento, String nombre) {
		super();
		this.id = id;
		this.id_departamento = id_departamento;
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_departamento() {
		return id_departamento;
	}


	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Provincias [id=" + id + ", id_departamento=" + id_departamento + ", nombre=" + nombre + "]";
	}

	
	
	
}
