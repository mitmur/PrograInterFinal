package edu.ulima.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProfesorDAO {
	

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
	
	public String nombreEst(int idEst) {
		String estudio="";
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from estudios where id=" + idEst );
			
			while(rs.next()){
				estudio=rs.getString(2);
			}
			desconectarse(conn);
			return estudio;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return null;
		}		
	}
	
	public List<Profesor> obtenerProfesores(){
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from profesores");
			List<Profesor> profesores = new ArrayList<Profesor>();
			while(rs.next()){
				profesores.add(new Profesor(
						rs.getInt("id"),
						rs.getString("nombres"),
						rs.getString("apellido_paterno"),
						rs.getString("apellido_materno"),
						rs.getString("dni"),
						rs.getString("foto_url"),
						rs.getInt("id_estudio"),
						nombreEst(rs.getInt("id_estudio"))
				));
			}
			desconectarse(conn);
			return profesores;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return null;
		}
	}
	
	public void grabarProfesor( Profesor p){
		String sql = "INSERT INTO profesores (nombres,apellido_paterno,apellido_materno,dni,foto_url,id_estudio) VALUES(?,?,?,?,?,?)";
		Connection conn = conectarse();
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, p.getNombres());
			stmt.setString(2, p.getApellido_paterno());
			stmt.setString(3, p.getApellido_materno());
			stmt.setString(4, p.getDni());
			stmt.setString(5, p.getFoto_url());
			stmt.setInt(6, p.getId_estudio());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);

		} finally {
			
			desconectarse(conn);
		}
			
	}
	
	public boolean validarDNI(String dni){
		Connection conn = conectarse();
		boolean cond=false;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select dni from profesores");
			
			while(rs.next() && cond==false){
				String dniIns = rs.getString(1);
				if(dniIns.equalsIgnoreCase(dni)){
					cond=true;
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
	
	public void editarProfesor(Profesor p){
		
		String sql= "UPDATE profesores set nombres=?, "
				+ "apellido_paterno=?, apellido_materno=?, foto_url=? , dni=?  ,id_estudio=?"
				+ " where id=?";
		Connection conn = conectarse();		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, p.getNombres());
			stmt.setString(2, p.getApellido_paterno());
			stmt.setString(3, p.getApellido_materno());			
			stmt.setString(4, p.getFoto_url());
			stmt.setString(5, p.getDni());
			stmt.setInt(6, p.getId_estudio());
			stmt.setInt(7,p.getId());
			

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);

		} finally {
			
			desconectarse(conn);
		}		
	}
	
	
	public Profesor obtenerDatosProfe(int id){
		Connection conn = conectarse();
		Profesor prof= new Profesor();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from profesores where id=" + id );
			
			while(rs.next()){
				prof = new Profesor(
						rs.getInt("id"),
						rs.getString("nombres"),
						rs.getString("apellido_paterno"),
						rs.getString("apellido_materno"),
						rs.getString("dni"),
						rs.getString("foto_url"),
						rs.getInt("id_estudio"));
			}
			desconectarse(conn);
			return prof;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return null;
		}
		
	}
	
	public void eliminarProfesor(int id){
		Connection conn=conectarse();
		String sql="delete from profesores where id = " + id;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
		}		
	}
	
}
