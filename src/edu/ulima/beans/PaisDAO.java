package edu.ulima.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO {
	private Connection conectarse(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/prografinal", "root", "IngSistem4s");
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
	
	public String nombrePais(int idPais) {
		String nompais="";
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from paises where id=" + idPais );
			
			while(rs.next()){
				nompais=rs.getString(2);
			}
			desconectarse(conn);
			return nompais;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return null;
		}		
	}
	
	public List<Pais> obtenerPaises(){
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from paises");
			List<Pais> paises = new ArrayList<Pais>();
			while(rs.next()){
				paises.add(new Pais(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("pbi")
				));
			}
			desconectarse(conn);
			return paises;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return null;
		}
	}
	
	public void grabarPais( Pais p){
		String sql = "INSERT INTO paises (id,nombre,pbi) VALUES(?,?,?)";
		Connection conn = conectarse();
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getNombre());
			stmt.setInt(3, p.getPbi());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);

		} finally {
			
			desconectarse(conn);
		}
			
	}
	
	/*public boolean validarDNI(String dni){
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
	}*/
	
	public void editarPais(Pais p){
		
		String sql= "UPDATE paises set nombre=?, "
				+ "pbi=?"
				+ " where id=?";
		Connection conn = conectarse();		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getPbi());
			stmt.setInt(3,p.getId());
			

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);

		} finally {
			
			desconectarse(conn);
		}		
	}
	
	
	public Pais obtenerDatosPais(int id){
		Connection conn = conectarse();
		Pais pais= new Pais();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from paises where id=" + id );			
			while(rs.next()){
				pais = new Pais(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("pbi"));
			
			}
			desconectarse(conn);
			return pais;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return null;
		}
		
	}
	
	public void eliminarPais(int id){
		Connection conn=conectarse();
		String sql="delete from paises where id = " + id;
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
		}		
	}
	
	
	
}
