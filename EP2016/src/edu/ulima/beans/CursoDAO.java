package edu.ulima.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
	
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
	public List<Curso> obtenerCurso(){
		Connection conn = conectarse();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from cursos");
			List<Curso> cursos = new ArrayList<>();
			while(rs.next()){
				cursos.add(new Curso(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
			desconectarse(conn);
			return cursos;
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarse(conn);
			return null;
		}
	}
}
