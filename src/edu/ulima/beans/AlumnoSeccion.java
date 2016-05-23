package edu.ulima.beans;

public class AlumnoSeccion {

	private int id;
	private int id_alumno;
	private int id_seccion;
	
	public AlumnoSeccion() {
	}
	
	public AlumnoSeccion(int id, int id_alumno, int id_seccion) {
		this.id = id;
		this.id_alumno = id_alumno;
		this.id_seccion = id_seccion;
	}
	
	

	public AlumnoSeccion(int id_alumno, int id_seccion) {
		super();
		this.id_alumno = id_alumno;
		this.id_seccion = id_seccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public int getId_seccion() {
		return id_seccion;
	}

	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}

	@Override
	public String toString() {
		return "AlumnoSeccion [id=" + id + ", id_alumno=" + id_alumno + ", id_seccion=" + id_seccion + "]";
	}
	
	
}
