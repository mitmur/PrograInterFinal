package edu.ulima.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlumnoSeccionDAO {

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
	
	public int getidAlumno(int id){
		Connection conn=conectarse();
		int idAlSec=0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from alumnos_secciones where id_alumno="+id);
			
			while(rs.next()){
				idAlSec=rs.getInt("id");
			}
			desconectarse(conn);
			return idAlSec;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return 0;
		}
	}		
	
	
	public void eliminarAlumnoSeccion(int id){
		Connection conn=conectarse();
		String sql="delete from alumnos_secciones where id = " + getidAlumno(id);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
		}		
	}
	
	public void agregarAlumnoSeccion(AlumnoSeccion alsec){
		
		String sql = "INSERT INTO alumnos_secciones (id_alumno,id_seccion) VALUES(?,?)";
		Connection conn = conectarse();
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, alsec.getId_alumno());
			stmt.setInt(2, alsec.getId_seccion());
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);

		} finally {
			
			desconectarse(conn);
		}
	}
	
	public List<AlumnoSeccion> obtenerAlumnoSeccion(){
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from alumnos_secciones");
			List<AlumnoSeccion> alumsecc = new ArrayList<AlumnoSeccion>();
			while(rs.next()){
				alumsecc.add(new AlumnoSeccion(
						rs.getInt("id"),
						rs.getInt("id_alumno"),
						rs.getInt("id_seccion")
				));
			}
			desconectarse(conn);
			return alumsecc;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return null;
		}
	}	
}
