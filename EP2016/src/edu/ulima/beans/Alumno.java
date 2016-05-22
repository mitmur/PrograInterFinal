package edu.ulima.beans;

import java.io.Serializable;

public class Alumno implements Serializable{

	private int id;
	private String nombres;
	private String apellido_paterno;
	private String apellido_materno;
	private String dni;
	private String foto_url;
	private int codigo;
	private int id_colegio;
	
	public Alumno() {
	}

	public Alumno(int id, String nombres, String apellido_paterno, String apellido_materno, String dni, String foto_url,
			int codigo, int id_colegio) {
		this.id = id;
		this.nombres = nombres;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.dni = dni;
		this.foto_url = foto_url;
		this.codigo = codigo;
		this.id_colegio = id_colegio;
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

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getId_colegio() {
		return id_colegio;
	}

	public void setId_colegio(int id_colegio) {
		this.id_colegio = id_colegio;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombres=" + nombres + ", apellido_paterno=" + apellido_paterno
				+ ", apellido_materno=" + apellido_materno + ", dni=" + dni + ", foto_url=" + foto_url + ", codigo="
				+ codigo + ", id_colegio=" + id_colegio + "]";
	}
	
	
}
