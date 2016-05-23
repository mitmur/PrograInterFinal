package edu.ulima.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
	
	private Connection conectarse(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ep", "root", "IngSistem4s");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	private void desconectarse(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public boolean alumnoPertenece(int id){
		boolean cond= false;	
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from alumnos_secciones ");
			
			while(rs.next()){
				if(rs.getInt("id_alumno")==id){
					cond=true;
				}else{
					cond=false;
				}
			}
			desconectarse(conn);
			return cond;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return cond;
		}
	}
	
	public List<Alumno> obtenerAlumnos(){
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from alumnos");
			List<Alumno> alumnos = new ArrayList<Alumno>();
			while(rs.next()){
				alumnos.add(new Alumno(
						rs.getInt("id"),
						rs.getString("nombres"),
						rs.getString("apellido_paterno"),
						rs.getString("apellido_materno"),
						rs.getString("dni"),
						rs.getString("foto_url"),
						rs.getInt("codigo"),
						rs.getInt("id_colegio"),
						alumnoPertenece(rs.getInt("id"))
				));
			}
			desconectarse(conn);
			return alumnos;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return null;
		}
	}		
	
	public Alumno obtenerAlumnoPorId(int id){
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from alumno where id=" + id);
			
			Alumno alumno = new Alumno();
			while(rs.next()){
					alumno= new Alumno(rs.getInt("id"), rs.getString("nombres"),
							rs.getString("apellido_paterno"),rs.getString("apellido_materno"),
							rs.getString("dni"),rs.getString("foto_url"),
							rs.getInt("codigo"),rs.getInt("id_colegio"));
					
			}
			desconectarse(conn);
			return alumno;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return null;
		}
	}	
	

}
