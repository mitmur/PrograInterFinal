package edu.ulima.beans;


public class Departamento {
	
	private int id;
	private String nombre;
	private int id_pais;
	
	public Departamento(int id, String nombre, int id_pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.id_pais = id_pais;
	}
	
	
	public Departamento() {
		super();
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
	public int getId_pais() {
		return id_pais;
	}
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}



	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", id_pais=" + id_pais + "]";
	}
	
	

}
