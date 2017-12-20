package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import model.CatalogueFut;


public class CatalogueFutDAO extends GenericImplDAO<CatalogueFut> {

	public ConnectionFactory daoFactory;



	public CatalogueFutDAO() {
		super();
		this.Entity = "CatalogueFut";
	}


	public CatalogueFut addFut(CatalogueFut F) {
		
		return null;
	}
	
	
	@Override
	public List<CatalogueFut> FindByListId(Object idFut) {
		daoFactory = new ConnectionFactory();
	    Query query = daoFactory.getEntityManager("Jax-rs_Gestion_Fut").createNamedQuery("CatalogueFut.findAllId");
		query.setParameter("idFut",idFut);
		List<CatalogueFut> list = query.getResultList( );
		return list;
	}
	@Override
	public List<CatalogueFut> getAll() {
		daoFactory = new ConnectionFactory();
		Query query =daoFactory.getEntityManager("Jax-rs_Gestion_Fut").createNamedQuery("CatalogueFut.findAll");
		List<CatalogueFut> list=query.getResultList();
		return list;
	}
	
	@Override
	public List<CatalogueFut> FindByListName(String Name) {
		daoFactory = new ConnectionFactory();
	    Query query = daoFactory.getEntityManager("Jax-rs_Gestion_Fut").createNamedQuery("CatalogueFut.findAllName");
		query.setParameter("NameFut",Name);
		List<CatalogueFut> list = query.getResultList( );
		return list;
	}
	
	public CatalogueFut FindById(Object idFut) {
		daoFactory = new ConnectionFactory();
	    Query query = daoFactory.getEntityManager("Jax-rs_Gestion_Fut").createNamedQuery("CatalogueFut.findAllId");
		query.setParameter("idFut",idFut);
		CatalogueFut list = (CatalogueFut)query.getSingleResult();
		return list;
	}
	public CatalogueFut FindByName(String Name) {
		daoFactory = new ConnectionFactory();
	    Query query = daoFactory.getEntityManager("Jax-rs_Gestion_Fut").createNamedQuery("CatalogueFut.findAllName");
		query.setParameter("NameFut",Name);
		CatalogueFut list = (CatalogueFut) query.getSingleResult();
		return list;
	}
	@Override
	public Response Create(CatalogueFut fut)
	{    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut") ;
	      EntityManager entity = emfactory.createEntityManager();
	      entity.getTransaction( ).begin( );
	      entity.persist(fut);
	      entity.getTransaction( ).commit( );
	      entity.close( );
		emfactory.close( );
		String json ="le Numero"+fut.getFutId()+"est Inserer";
		return  Response.status(200).type("application/json").entity(json).build();
	}
	

	@Override
	public Response Update(CatalogueFut Fut) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut") ;
		EntityManager f =  emfactory.createEntityManager();
		CatalogueFut cat =  f.find( CatalogueFut.class,Fut.getFutId() );
		f.getTransaction().begin();
		cat.setFutDescrCatalogueFut(Fut.getFutDescrCatalogueFut());
		cat.setFutNomCatalogueFut(Fut.getFutNomCatalogueFut());
		f.getTransaction().commit();
		//after update
		f.close();
		emfactory.close();
		String json ="le Numero"+Fut.getFutNomCatalogueFut()+"est Modifier";
		return  Response.status(200).type("application/json").entity(json).build(); 
	}
	
	@Override
	public Response DeleteFuts(Object Fut_id) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut") ;
		EntityManager f =  emfactory.createEntityManager();
		f.getTransaction( ).begin();
		CatalogueFut Catfut =f.find( CatalogueFut.class, Fut_id );
		f.remove(Catfut);
		f.getTransaction( ).commit( );
		String json ="le Numero"+Fut_id+"est supprimer";
		return  Response.status(200).type("application/json").entity(json).build(); 
    
	}
	

		
}
