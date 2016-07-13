package edu.ulima.db;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import pc4_clases.Distrito;



public class MongoDAO {

	MongoClient mongoClient = null;
	MongoDatabase db = null;	
	

	private void getConnection() {
		mongoClient = new MongoClient();
		db = mongoClient.getDatabase("db20130527");
	}
	
	
	private void insertaMuchos() {
		getConnection();
		MongoCollection<Document> distritos = db.getCollection("db20130527");
		
		MysqlDao m = new MysqlDao();
		m.obtenerDistritos();
		
		
		
		// Generar los documentos
		List<Document> documents = new ArrayList<Document>();
		for (Distrito d:m.obtenerDistritos()) {
			Document doc = new Document("id", d.getId())
		               .append("id_provincia", d.getId_provincia())
		               .append("nombre", d.getNombre())
		               .append("poblacion",d.getPoblacion() );
			
			
		    documents.add(doc);
		}
		
		distritos.insertMany(documents);
		
	
	
}
	
	
}
