package Dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public abstract class GenericImplDAO<T> {
  
	protected Class<T> EntityClass;
	protected EntityManager entityManager;
	protected EntityManagerFactory entityManagerFactory;
	protected String[] parameter;
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
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut");
			entityManager = factory.createEntityManager();
	    
	       return entityManager;
         }
		public  EntityManagerFactory getEntityManagerFactory()
		{
 
			entityManagerFactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut");
	    
	       return entityManagerFactory;
         }
		
		public void create(T entity)
		{   
		EntityManagerFactory emfactory = getEntityManagerFactory() ;
   		EntityManager emanage =  getEntityManager();
   		emanage.getTransaction().begin();
   		emanage.persist(entity);
   		emanage.getTransaction( ).commit( );
   		emanage.close( );
   		emfactory.close( );
		
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
       {     EntityManagerFactory factory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut");
		     entityManager = factory.createEntityManager();
    		Query query = entityManager.createNamedQuery(this.QUeryName);
    		List<T> list= query.getResultList();
    		getEntityManager().close();
    		return list;
    	   
       }
       public List<T> FindName(Object value)
       {  
    	   Query query = getEntityManager().createNamedQuery(this.QUeryName);
   		query.setParameter(this.parameter[0],value.toString());
   		List<T> list = query.getResultList( );
   		getEntityManagerFactory().close();
   		return list;
       }
       public List<T> FindJoint(Object[] value)
       {  
    Query query = getEntityManager().createNamedQuery(this.QUeryName);
	    	for (int i = 0; i < parameter.length; i++)
	    	{
	    		   query.setParameter(this.parameter[i],Boolean.getBoolean(value[i].toString()));
		          	
	    	}
	   		List<T> list = query.getResultList( );
	   		getEntityManagerFactory().close();
	   		return list;
       }
       
       public List<T> FindId(Object valueIdFut)
       {  
  Query query = getEntityManager().createNamedQuery(this.QUeryName);
		query.setParameter(this.parameter[0],valueIdFut);
		List<T> list = query.getResultList( );
		getEntityManagerFactory().close();
		return list;
       }
		
		
		
}
