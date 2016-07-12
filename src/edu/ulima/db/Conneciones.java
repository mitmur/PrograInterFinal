package edu.ulima.db;



import java.sql.DriverManager;
import java.sql.SQLException;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mysql.jdbc.Connection;

public class Conneciones {
	// 1: Definir una URL de conexion   
    private static String url = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/ad_55bfe84174d74d1";
    private static String user = "b988d75ac51271";
    private static String password = "eb0eb858";
	private MongoClient mongoClient;
 
    public Connection getConnectionMysql() {
        Connection con = null;
           try {
                // 2: Cargar el driver
               // puede lanzar la excepcion ClassNotFoundException
               Class.forName("com.mysql.jdbc.Driver");
               // 3: Obtener una conexion a la BD
               // Puede lanzar un SQLException
               con = (Connection) DriverManager.getConnection(url, user, password);
       
           } catch (ClassNotFoundException ex) {
               System.out.println("Verifica tu driver en el classpath");
           } catch (SQLException ex) {
               System.out.println("Verifica tus parametros de conexion");
           }
       
           return con;
    }
    
    public MongoDatabase getConnectionMongoDB(){
    	mongoClient = new MongoClient();
    	MongoDatabase db = mongoClient.getDatabase("db_peru");
    	
    	return db;
    }    
}
