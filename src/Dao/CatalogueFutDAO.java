package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import model.CatalogueFut;


public class CatalogueFutDAO extends GenericImplDAO<CatalogueFut> implements GenericDAO<CatalogueFut>{

	public ConnectionFactory daoFactory;
	


	public CatalogueFutDAO() {
		super();
		
	}


	public CatalogueFut addFut(CatalogueFut F) {
		
		return null;
	}
	
	/*List by Id fut*/
	@Override
	public List<CatalogueFut> FindByListId(Object ValueidFut) {
		this.parameter = new String[1];
		this.parameter[0]="futId";
		this.QUeryName ="CatalogueFut.findAllId";
		return this.FindId((int) ValueidFut);
	}
	/*List all of fut*/
	@Override
	public List<CatalogueFut> getAll() 
	{
		this.QUeryName = "CatalogueFut.findAll";
		return this.list();
	}
	
	/*List by name*/
	@Override
	public List<CatalogueFut> FindByListName(String Name) {
		this.parameter = new String[1];
		this.parameter[0] = "NameFut";
		this.QUeryName =  "CatalogueFut.findAllName";
		
		return this.FindName(Name);
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
		{    /*EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut") ;
		      EntityManager entity = emfactory.createEntityManager();
		      entity.getTransaction( ).begin( );
		      entity.persist(fut);
		      entity.getTransaction( ).commit( );
		      entity.close( );
		    emfactory.close( );*/
		    create(fut);
			String json ="le Numero"+fut.getFutId()+"est Inserer";
			return  Response.status(200).type("application/json").entity(json).build();
	}
	

	@Override
	public Response Update(CatalogueFut Fut) {

		
	   this.update(Fut);
		/* EntityManagerFactory factory = getEntityManagerFactory();
			EntityManager entitym = getEntityManager();
			
			entitym.getTransaction().begin();
			CatalogueFut cat  = entitym.find(CatalogueFut.class,Fut.getFutId());
			cat.setFutDescrCatalogueFut(Fut.getFutDescrCatalogueFut());
			cat.setFutNomCatalogueFut(Fut.getFutNomCatalogueFut());
			entitym.getTransaction().commit();
			entitym.close();
			factory.close();*/ 
		String json ="le Numero"+Fut.getFutNomCatalogueFut()+"est Modifier";
	
		
	return  Response.status(200).type("application/json").entity(json).build();}
	
	@Override
	public Response Delete(Object Fut_id) {
		
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
