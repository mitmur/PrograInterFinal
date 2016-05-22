package edu.ulima.beans;

public class Distrito {

	private int id;
	private String nombre;
	private int id_provincia;
	
	public Distrito() {
	}

	public Distrito(int id, String nombre, int id_provincia) {
		this.id = id;
		this.nombre = nombre;
		this.id_provincia = id_provincia;
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

	public int getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}

	@Override
	public String toString() {
		return "Distrito [id=" + id + ", nombre=" + nombre + ", id_provincia=" + id_provincia + "]";
	}
	
	
}
