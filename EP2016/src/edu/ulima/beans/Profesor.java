package edu.ulima.beans;

import java.io.Serializable;

public class Profesor implements Serializable {
	
	private int id;
	private String nombres;
	private String apellido_paterno;
	private String apellido_materno;
	private String dni;
	private String foto_url;
	private int id_estudio;
	private String nombreEstudios;
	
	public Profesor() {
		
	}
	public Profesor(int id,String nombres, String apellido_paterno, String apellido_materno, String dni,
			String foto_url, int id_estudio,String nombreEstudios) {	
		this.id = id;
		this.nombres = nombres;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.dni = dni;
		this.foto_url = foto_url;
		this.id_estudio = id_estudio;
		this.nombreEstudios = nombreEstudios;
	}

	public Profesor(int id,String nombres, String apellido_paterno, String apellido_materno, String dni,
			String foto_url, int id_estudio) {	
		this.id = id;
		this.nombres = nombres;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.dni = dni;
		this.foto_url = foto_url;
		this.id_estudio = id_estudio;
	}

	public Profesor(String nombres, String apellido_paterno, String apellido_materno, String dni,
			String foto_url, int id_estudio) {		
		this.nombres = nombres;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.dni = dni;
		this.foto_url = foto_url;
		this.id_estudio = id_estudio;
	}
	
	public String getNombreEstudios() {
		return nombreEstudios;
	}
	public void setNombreEstudios(String nombreEstudios) {
		this.nombreEstudios = nombreEstudios;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_parterno) {
		this.apellido_paterno = apellido_parterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFoto_url() {
		return foto_url;
	}

	public void setFoto_url(String foto_url) {
		this.foto_url = foto_url;
	}

	public int getId_estudio() {
		return id_estudio;
	}

	public void setId_estudio(int id_estudio) {
		this.id_estudio = id_estudio;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombres=" + nombres + ", apellido_parterno=" + apellido_paterno
				+ ", apellido_materno=" + apellido_materno + ", dni=" + dni + ", foto_url=" + foto_url + ", id_estudio="
				+ id_estudio + "]";
	}
	
	
}
