package edu.ulima.beans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class DistritoDAO {
	private EntityManager em;	
	
	public DistritoDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public void registrar(Distrito distrito){
		
		em.getTransaction().begin();
		em.persist(distrito);
		em.getTransaction().commit();
	}
	
	public List<Distrito> lista(){
		Query query=em.createQuery("SELECT d FROM distritos d");				
		List<Distrito> lista=(List<Distrito>)query.getResultList();
		return lista;
	}
	
	public List<Distrito> listaFiltro(Provincia prov){
		Query query=em.createQuery("SELECT d FROM Distritos d where d.provincia=:provincia");
		query.setParameter("provincia", prov);		
		List<Distrito> lista=(List<Distrito>)query.getResultList();
		return lista;
	}
}
