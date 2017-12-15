package Dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Categorie;

public class CatalogueFut {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut" );
	EntityManager entitymanager = emfactory.createEntityManager();
	public String ListCategories() {
		Query query = entitymanager.createNamedQuery("Categorie.findAll");
		Categorie employee =  entitymanager.find( Categorie.class, 2);
		
		return employee.getCatFut();
	}
}
