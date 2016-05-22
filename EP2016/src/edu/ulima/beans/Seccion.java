package edu.ulima.beans;

import java.io.Serializable;

public class Seccion implements Serializable{

	private int id;
	private int codigo;
	private int id_curso;
	private int id_profesor;
	private String nombreCurso;	
	private String nombreEscuela;
	
	public Seccion() {
	}
		
	public Seccion(int id, int codigo, int id_curso, int id_profesor, String nombreCurso, String nombreEscuela) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.id_curso = id_curso;
		this.id_profesor = id_profesor;
		this.nombreCurso = nombreCurso;
		this.nombreEscuela = nombreEscuela;
	}


	public Seccion(int codigo, int id_curso, int id_profesor) {		
		this.codigo = codigo;
		this.id_curso = id_curso;
		this.id_profesor = id_profesor;
	}
	

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getNombreEscuela() {
		return nombreEscuela;
	}

	public void setNombreEscuela(String nombreEscuela) {
		this.nombreEscuela = nombreEscuela;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public int getId_profesor() {
		return id_profesor;
	}

	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}

	@Override
	public String toString() {
		return "Seccion [id=" + id + ", codigo=" + codigo + ", id_curso=" + id_curso + ", id_profesor=" + id_profesor
				+ "]";
	}
	
	
}
