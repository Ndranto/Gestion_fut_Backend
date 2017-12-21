package Dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.CatalogueFut;

public abstract class GenericImplDAO<T> {
  
	protected Class<T> EntityClass;
	protected EntityManager entityManager;
	protected EntityManagerFactory entityManagerFactory;
	protected String parameter;
	protected Object id;
	protected String  persistence_Unit;
	protected String QUeryName;

	

	public Class<T> getEntityClass() {
		return EntityClass;
	}
	public void setEntityClass(Class<T> entityClass) {
		EntityClass = entityClass;
	}
		public String toString(){
		    String str = "Je suis un objet de la " + this.getClass() + ", laclass " + this.EntityClass + ", persistant " + this.persistence_Unit;
		    return str;
		  }  
		public  EntityManager getEntityManager()
		{

			entityManager = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut").createEntityManager();
	    
	       return entityManager;
         }
		public  EntityManagerFactory getEntityManagerFactory()
		{

			entityManagerFactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut");
	    
	       return entityManagerFactory;
         }
		
		public void create(T entity)
		{   
			
			getEntityManager().getTransaction( ).begin();
			getEntityManager().persist(entity);
			getEntityManager().getTransaction( ).commit( );
			getEntityManager().close( );
			getEntityManagerFactory().close( );
		
		}
       public void update(T entity)
       {
    	    EntityManagerFactory emfactory = getEntityManagerFactory() ;
   		    EntityManager emanage =  getEntityManager();
   		    emanage.getTransaction().begin();
	   		emanage.merge(entity);
	   		emanage.getTransaction().commit();
	   		emanage.close();
			emfactory.close();   
       }
       public List<T> list()
       {
    		Query query = getEntityManager().createNamedQuery(this.QUeryName);
    		List<T> list= query.getResultList();
    		return list;
    	   
       }
       public List<T> FindName(Object value)
       {
    	   Query query = getEntityManager().createNamedQuery(this.QUeryName);
   		query.setParameter(this.parameter,value.toString());
   		List<T> list = query.getResultList( );
   		getEntityManagerFactory().close();
   		return list;
       }
       
       public List<T> FindId(Object valueIdFut)
       {  Query query = getEntityManager().createNamedQuery(this.QUeryName);
		query.setParameter(this.parameter.toString(),valueIdFut);
		List<T> list = query.getResultList( );
		getEntityManagerFactory().close();
		return list;
       }
		
		
		
}
