package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.CatalogueFut;
import model.Categorie;
import Controller.ICollectionFutCategorie;

public class CatalogueFutDAO implements ICollectionFutCategorie {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut" );
	EntityManager entitymanager = emfactory.createEntityManager();
	
	@Override
	public Categorie addCatégorie(Categorie C) {
	
				entitymanager.getTransaction( ).begin( );
				entitymanager.persist(C);
				entitymanager.getTransaction( ).commit( );
				entitymanager.close( );
				emfactory.close( );
	
		return C;
	}
	@Override
	public CatalogueFut addFut(CatalogueFut F) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Categorie> ListCategories() {
		Query query = entitymanager.createNamedQuery("Categorie.findAll");
		  List<Categorie> list=query.getResultList();
		  for(Categorie e:list)
			{
			System.out.println("Id NAME :"+e.getCatId());
			System.out.println("Cat NAME :"+e.getCatFut());
			}
		return list;
	}
	
	@Override
	public List<CatalogueFut> listFutCategorie(Integer idCategorie) {
		
		return null;
	}
	@Override
	public List<CatalogueFut> listFut() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CatalogueFut> listFutName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Categorie updateCategories(Categorie C) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CatalogueFut updateCategories(CatalogueFut F) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean DeleteFuts(Integer Fut_id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Categorie getCategorier(Integer idCategories) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CatalogueFut getFut(Integer Fut_Id) {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}
