package Dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class GenericImplDAO<T>  implements GenericDAO<T>{
  
	protected EntityManager entityManager;
	public String  Entity;
	protected String  persistence_Unit;
	

	    public String toString(){
		    String str = "Je suis un objet de la " + this.getClass() + ", laclass " + this.Entity + ", persistant " + this.persistence_Unit;
		    return str;
		  }  
		public  EntityManager getEntityManager()
		{

			entityManager = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut").createEntityManager();
	    
	       return entityManager;
         }

		
		
		
}
