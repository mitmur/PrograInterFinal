package edu.ulima.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.ulima.beans.Departamento;
import edu.ulima.beans.Distrito;
import edu.ulima.beans.Provincias;

public class MysqlDao {
	
	
		private Connection conectarse(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbPeru", "root", "IngSistem4s");
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
		
		
		public List<Distrito> obtenerDistritos(){
			Connection conn = conectarse();
			
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from distritos");
				List<Distrito> distritos = new ArrayList<Distrito>();
				while(rs.next()){
					distritos.add(new Distrito(
							rs.getInt("id"),
							rs.getInt("id_provincia"),
							rs.getString("nombre"),
							rs.getInt("poblacion")
					));
				}
				desconectarse(conn);
				return distritos;
			} catch (SQLException e) {
				e.printStackTrace();
				desconectarse(conn);
				return null;
			}
		}
		
		public List<Provincias> obtenerProvincias(){
			Connection conn = conectarse();
			
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from provincias");
				List<Provincias> provincias = new ArrayList<Provincias>();
				while(rs.next()){
					provincias.add(new Provincias(
							rs.getInt("id"),
							rs.getInt("id_provincia"),
							rs.getString("nombre")
							
					));
				}
				desconectarse(conn);
				return provincias;
			} catch (SQLException e) {
				e.printStackTrace();
				desconectarse(conn);
				return null;
			}
		}
		
		public List<Departamento> obtenerDepartamentos(){
			Connection conn = conectarse();
			
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from departamentos");
				List<Departamento> departamentos = new ArrayList<Departamento>();
				while(rs.next()){
					departamentos.add(new Departamento(
							rs.getInt("id"),
							rs.getString("nombre"),
							rs.getInt("id_provincia")
							
					));
				}
				desconectarse(conn);
				return departamentos;
			} catch (SQLException e) {
				e.printStackTrace();
				desconectarse(conn);
				return null;
			}
		}


}

