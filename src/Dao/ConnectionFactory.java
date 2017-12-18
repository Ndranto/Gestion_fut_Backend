package Dao;

import javax.persistence.*;

public  class ConnectionFactory
{
	public ConnectionFactory() {	}
			private static EntityManagerFactory entityManagerFactory;
			private static EntityManager entityManager;
	public  EntityManager getEntityManager(String persistence_unit){

				entityManager = Persistence.createEntityManagerFactory(persistence_unit).createEntityManager();
		    
		return entityManager;
	}
}