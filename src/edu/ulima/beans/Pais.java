package edu.ulima.beans;

public class Pais {

	private int id;
	private String nombre;
	private int pbi;
	
	
	public Pais(int id, String nombre, int pbi) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pbi = pbi;
	}


	public Pais() {
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


	public int getPbi() {
		return pbi;
	}


	public void setPbi(int pbi) {
		this.pbi = pbi;
	}


	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + ", pbi=" + pbi + "]";
	}
	
	
	
}
