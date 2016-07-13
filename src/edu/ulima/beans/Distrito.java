package edu.ulima.beans;


public class Distrito {
	
	
	private int id;
	private int id_provincia;
	private String nombre;
	private int poblacion;
	
	
	public Distrito() {
		super();
	}


	public Distrito(int id, int id_provincia, String nombre, int poblacion) {
		super();
		this.id = id;
		this.id_provincia = id_provincia;
		this.nombre = nombre;
		this.poblacion = poblacion;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_provincia() {
		return id_provincia;
	}


	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}


	@Override
	public String toString() {
		return "Distrito [id=" + id + ", id_provincia=" + id_provincia + ", nombre=" + nombre + ", poblacion="
				+ poblacion + "]";
	}
	
	
	

}
