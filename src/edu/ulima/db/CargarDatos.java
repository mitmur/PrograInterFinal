package edu.ulima.beans;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.owlike.genson.Genson;

import pe.ulima.edu.Conexion;
import pe.ulima.edu.models.Departamento;
import pe.ulima.edu.models.DepartamentoDAO;
import pe.ulima.edu.models.Distrito;
import pe.ulima.edu.models.DistritoDAO;
import pe.ulima.edu.models.Pais;
import pe.ulima.edu.models.PaisDAO;
import pe.ulima.edu.models.Provincia;
import pe.ulima.edu.models.ProvinciaDAO;

public class CargarDatos {

	public static void main(String[] args) {
		
		Conexion.getInstancia().conectarse();
		
		try {
			MongoClient mongoClientLocal = new MongoClient( "localhost" , 27017 );
			
			DB db = mongoClientLocal.getDB("CODIGOOOOOOOOOOOO!!!!!!!");
			
			
			DBCollection colPaises = db.getCollection("paises");
			PaisDAO paisDAO=new PaisDAO(Conexion.getInstancia().getEntityManager());
			
			DBCollection colDepartamentos = db.getCollection("departamentos");			
			DepartamentoDAO departamentoDAO=new DepartamentoDAO(Conexion.getInstancia().getEntityManager());
			
			DBCollection colProvincias = db.getCollection("provincias");
			ProvinciaDAO provinciaDAO=new ProvinciaDAO(Conexion.getInstancia().getEntityManager());
			
			DBCollection colDistritos = db.getCollection("distritos");
			DistritoDAO distritoDAO=new DistritoDAO(Conexion.getInstancia().getEntityManager());
			
			List<Pais> paises = paisDAO.lista();
			for(Pais pais : paises){
				DBObject paisJSON=new BasicDBObject();
				
				paisJSON.put("nombre", pais.getNombre());
				paisJSON.put("poblacion", pais.getPoblacion());
				paisJSON.put("pbi", pais.getPbi());
				
				List<Departamento> departamentos=departamentoDAO.listaFiltro(pais);
				List<DBObject> listaDptoJSON=new ArrayList<>();
				
				for(Departamento dpto : departamentos){
					DBObject dptoJSON=new BasicDBObject();
					dptoJSON.put("nombre",dpto.getNombre());
					
					List<Provincia> provincias=provinciaDAO.listaFiltro(dpto);
					List<DBObject> listaProvJson=new ArrayList<>();
					
					for(Provincia prov : provincias){
						DBObject provJSON=new BasicDBObject();
						provJSON.put("nombre", prov.getNombre());
						
						List<Distrito> distritos=distritoDAO.listaFiltro(prov);
						List<DBObject> listaDistJson=new ArrayList<>();
						
						for(Distrito distrito : distritos){
							DBObject distJSON=new BasicDBObject();							
							distJSON.put("nombre", distrito.getNombre());
							distJSON.put("poblacion", distrito.getPoblacion());
							colDistritos.insert(distJSON);
							listaDistJson.add(distJSON);
						}
						provJSON.put("distritos", listaDistJson);
						
						colProvincias.insert(provJSON);
						listaProvJson.add(provJSON);
					}
					dptoJSON.put("provincias", listaProvJson);
					colDepartamentos.insert(dptoJSON);
					listaDptoJSON.add(dptoJSON);
				}
				
				paisJSON.put("departamentos", listaDptoJSON);
				colPaises.insert(paisJSON);				
				
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		Conexion.getInstancia().desconectarse();
	}

}
