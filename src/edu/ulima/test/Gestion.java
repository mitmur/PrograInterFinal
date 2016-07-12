package edu.ulima.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mysql.jdbc.PreparedStatement;
import static com.mongodb.client.model.Filters.*;

import edu.ulima.db.Conneciones;

public class Gestion {

	public void insertarDepartamentos(){
        Conneciones c = new Conneciones();
        Connection con = c.getConnectionMysql();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        
        String consulta = "SELECT * FROM tb_departamento;";
        
        try {
			psmt = (PreparedStatement) con.prepareStatement(consulta);
			rs = psmt.executeQuery();
			while (rs.next()) {
            	int id = rs.getInt(1);
            	String nombre = rs.getString(2);
            	
            	MongoDatabase db = c.getConnectionMongoDB();
        		MongoCollection<Document> col = db.getCollection("departamentos");
        		
        		Document doc = new Document();
        		doc.append("id_departamento", id);
        		doc.append("nombre", nombre);
        		
        		col.insertOne(doc);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
	}
	
	public void insertarProvincias(){
        Conneciones c = new Conneciones();
        Connection con = c.getConnectionMysql();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        
        String consulta = "SELECT id, id_departamento, nombre FROM tb_provincia;";
        
        try {
			psmt = (PreparedStatement) con.prepareStatement(consulta);
			rs = psmt.executeQuery();
			while (rs.next()) {
            	int id = rs.getInt(1);
            	int id_departamento = rs.getInt(2);
            	String nombre = rs.getString(3);        	
            	
            	MongoDatabase db = c.getConnectionMongoDB();
        		MongoCollection<Document> col = db.getCollection("provincias");
        		
        		Document doc = new Document();
        		doc.append("id_departamento", id_departamento);
        		doc.append("id_provincia", id);
        		doc.append("nombre", nombre);
        		
        		col.insertOne(doc);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertarDistritos(){
        Conneciones c = new Conneciones();
        Connection con = c.getConnectionMysql();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        
        String consulta = "SELECT id, id_provincia, nombre FROM tb_distrito;";
        
        try {
			psmt = (PreparedStatement) con.prepareStatement(consulta);
			rs = psmt.executeQuery();
			while (rs.next()) {
            	int id = rs.getInt(1);
            	int id_provincia= rs.getInt(2);
            	String nombre = rs.getString(3);        	
            	
            	MongoDatabase db = c.getConnectionMongoDB();
        		MongoCollection<Document> col = db.getCollection("distritos");
        		
        		Document doc = new Document();
        		doc.append("id_provincia", id_provincia);
        		doc.append("id_distrito", id);
        		doc.append("nombre", nombre);
        		
        		col.insertOne(doc);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizarProvincias(){
		Conneciones c = new Conneciones();
        
		MongoDatabase db = c.getConnectionMongoDB();
		MongoCollection<Document> distritos = db.getCollection("distritos");
		MongoCollection<Document> provincias = db.getCollection("provincias");
				
		MongoCursor<Document> cursor = provincias.find().iterator();
		try {
		    while (cursor.hasNext()) {
		    	Document doc = cursor.next();
		    	String t = doc.get("id_provincia").toString();
		    	int id_provincia = Integer.parseInt(t);
		    	DBObject filtro = new BasicDBObject();
		    	
		    	MongoCursor<Document> cursor2 = 
		    			distritos.find(eq("id_provincia", id_provincia)).iterator();
		    	
		    }
		} finally {
		    cursor.close();
		}
		
		
		
		/*Document doc = new Document();
		doc.append("id_provincia", id_provincia);
		doc.append("id_distrito", id);
		doc.append("nombre", nombre);
		
		col.insertOne(doc);*/
    
	}
}
