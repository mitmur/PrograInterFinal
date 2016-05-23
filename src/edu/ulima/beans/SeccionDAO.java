package edu.ulima.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SeccionDAO {

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
	
	public String nombreProfe(int id){
		String nombreP="";
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select nombres,apellido_paterno,apellido_materno"
					+ " from profesores where id=" + id);
			while(rs.next()){
			nombreP= rs.getString("nombres") + " " + rs.getString("apellido_paterno") + " " + 
					rs.getString("apellido_materno");		
			}						
			desconectarse(conn);
			return nombreP;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return "encontre nada";
		}
	}
	
	public Seccion obtenerSeccion(int id){
		Connection conn = conectarse();
		Seccion seccion = new Seccion();	
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from secciones where id=" + id);
			
			
			while(rs.next()){
				
				Curso cursos=nombreCurso(rs.getInt("id_curso"));				
				seccion =new Seccion(
						rs.getInt("id"),
						rs.getInt("codigo"),
						rs.getInt("id_curso"),						
						rs.getInt("id_profesor"),
						cursos.getNombre(),
						nombreEscuela(cursos.getId_carrera()),
						nombreProfe(rs.getInt("id_profesor")));
			}
			desconectarse(conn);
			return seccion;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			Seccion secfallida = new Seccion(5, 000, 000, 000, "nada", "nada", "nada");
			return secfallida;
		}
	}
	
	
	public List<Seccion> obtenerSecciones(){
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from secciones");
			List<Seccion> secciones = new ArrayList<Seccion>();		
			
			while(rs.next()){
				
				Curso cursos=nombreCurso(rs.getInt("id_curso"));				
				secciones.add(new Seccion(
						rs.getInt("id"),
						rs.getInt("codigo"),
						rs.getInt("id_curso"),						
						rs.getInt("id_profesor"),
						cursos.getNombre(),
						nombreEscuela(cursos.getId_carrera())));
			}
			desconectarse(conn);
			return secciones;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return null;
		}
	}
	
	public void grabarSecciones( Seccion s){
		String sql = "INSERT INTO secciones(codigo,id_curso,id_profesor) VALUES(?,?,?)";
		Connection conn = conectarse();
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, s.getCodigo());
			stmt.setInt(2, s.getId_curso());
			stmt.setInt(3, s.getId_profesor());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);

		} finally {
			desconectarse(conn);
		}
			
	}
	
	public boolean validarCOD(int cod){
		Connection conn = conectarse();
		boolean cond=false;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select codigo from secciones");
			
			while(rs.next() && cond==false){
				int codIns = rs.getInt(1);
				if(cod==codIns){
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

	public Curso nombreCurso(int id){
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select nombre,id_escuela"
					+ " from cursos where id=" + id);
			Curso cursos=new Curso();
			while(rs.next()){
			cursos=new Curso(rs.getString("nombre"),rs.getInt("id_escuela"));	
			
			
			}						
			desconectarse(conn);
			return cursos;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return null;
		}
	}
	
	public String nombreEscuela(int id){
		String nombreP="";
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select nombre"
					+ " from escuelas where id=" + id);
			while(rs.next()){
				
			nombreP= rs.getString("nombre");
			
			}						
			desconectarse(conn);
			return nombreP;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return "encontre nada";
		}
	}
	
public void editarSeccion(Seccion s){
		
		String sql= "UPDATE secciones set codigo=?, "
				+ "id_curso=?, id_profesor=?"
				+ " where id=?";
		Connection conn = conectarse();		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, s.getCodigo());
			stmt.setInt(2, s.getId_curso());
			stmt.setInt(3, s.getId_profesor());	
			stmt.setInt(4,s.getId());
			

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);

		} finally {
			
			desconectarse(conn);
		}		
	}

public void eliminarSeccion(int id){
	Connection conn=conectarse();
	String sql="delete from secciones where id = " + id;
	try {
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		desconectarse(conn);
	}		
}

}
