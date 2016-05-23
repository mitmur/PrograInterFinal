package edu.ulima.beans;

public class Curso {

	private int id;
	private String nombre;
	private int codigo;
	private int id_carrera;
	
	public Curso() {
	}

	public Curso(String nombre, int id_carrera) {
		super();
		this.nombre = nombre;
		this.id_carrera = id_carrera;
	}

	public Curso(int id, String nombre, int codigo, int id_carrera) {
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.id_carrera = id_carrera;
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

	public int getId_carrera() {
		return id_carrera;
	}

	public void setId_carrera(int id_carrera) {
		this.id_carrera = id_carrera;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", id_carrera=" + id_carrera + "]";
	}
	
	
}
