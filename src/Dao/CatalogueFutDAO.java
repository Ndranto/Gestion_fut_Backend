package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;

import model.CatalogueFut;
import model.Categorie;
import Controller.ICollectionFutCategorie;

public class CatalogueFutDAO  {

	public ConnectionFactory daoFactory;

	
	
	
	public CatalogueFut addFut(CatalogueFut F) {
		
		return null;
	}
	
	
	public List<CatalogueFut> FindById(Integer idCategorie) {
		daoFactory = new ConnectionFactory();
	    Query query = daoFactory.getEntityManager("Jax-rs_Gestion_Fut").createNamedQuery("CatalogueFut.findAllId");
		query.setParameter("idFut",idCategorie);
		List<CatalogueFut> list = query.getResultList( );
		return null;
	}
	
	
	public List<Categorie> getAll() {
		daoFactory = new ConnectionFactory();
		Query query =daoFactory.getEntityManager("Jax-rs_Gestion_Fut").createNamedQuery("CatalogueFut.findAll");
		List<Categorie> list=query.getResultList();
		return list;
	}
	
	public List<CatalogueFut> FindByName(String Name) {
		daoFactory = new ConnectionFactory();
	    Query query = daoFactory.getEntityManager("Jax-rs_Gestion_Fut").createNamedQuery("CatalogueFut.findAllName");
		query.setParameter("NameFut",Name);
		List<CatalogueFut> list = query.getResultList( );
		return list;
	}
	
	public boolean Create(CatalogueFut fut)
	{    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut") ;
		daoFactory.getEntityManager("Jax-rs_Gestion_Fut").getTransaction( ).begin( );
		daoFactory.getEntityManager("Jax-rs_Gestion_Fut").persist(fut);
		daoFactory.getEntityManager("Jax-rs_Gestion_Fut").getTransaction( ).commit( );
		daoFactory.getEntityManager("Jax-rs_Gestion_Fut").close( );
		emfactory.close( );
		return true;
	}
	

	
	public CatalogueFut Update(CatalogueFut F) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut") ;
		CatalogueFut Catfut =  daoFactory.getEntityManager("Jax-rs_Gestion_Fut").find( CatalogueFut.class, F.getFutId() );
		Catfut.setFutNomCatalogueFut("dqfq");
		Catfut.setFutDescrCatalogueFut("efqfq");
		daoFactory.getEntityManager("Jax-rs_Gestion_Fut").getTransaction( ).commit( );
		daoFactory.getEntityManager("Jax-rs_Gestion_Fut").close();
		emfactory.close();
		return null;
	}
	
	public boolean DeleteFuts(Object Fut_id) {
		
		return false;
	}
	

		
}
