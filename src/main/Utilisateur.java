package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Dao.CatalogueFutDAO;


public class Utilisateur {
	public static void main( String[ ] args )
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut" );
		EntityManager entitymanager = emfactory.createEntityManager();
				CatalogueFutDAO f = new CatalogueFutDAO();
		/*  ---------------------Create -------------------*/
	/*EntityManagerFactory emfactory = Persistence.
	createEntityManagerFactory( "Jax-rs_Gestion_Fut" );
	EntityManager entitymanager = emfactory.
	createEntityManager( );
	entitymanager.getTransaction( ).begin( );
	Utilisteur employee = new Utilisteur( );
	employee.setUser_Id(3);
	employee.setUser_Name( "Gopal" );
	employee.setUse_Pw("Aller");
	entitymanager.persist( employee );
	entitymanager.getTransaction( ).commit( );
	entitymanager.close( );
	emfactory.close( );*/
		
		/*  ---------------------Find -------------------
	    /* EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut" );
			EntityManager entitymanager = emfactory.createEntityManager();
			Utilisteur employee =  entitymanager.find( Utilisteur.class, 1 );
			System.out.println("ID = "+employee.getUser_Id());
			System.out.println("NAME = "+employee.getUser_Name());
			System.out.println("PW = "+employee.getUse_Pw());/*
			
			 ---------------------Delete -------------------

			Utilisteur employee =  entitymanager.find( Utilisteur.class, 3 );
			entitymanager.remove( employee );
			entitymanager.getTransaction( ).commit( );
			entitymanager.close( );
			/*  ---------------------UPDATE -------------------
		
			Utilisteur employee =  entitymanager.find( Utilisteur.class, 1 );
			//before update
			System.out.println( employee );
			employee.setUser_Name("ANdriamamonjisoa");
			employee.setUse_Pw("HMNAJ");
			entitymanager.getTransaction( ).commit( );
			//after update
			System.out.println( employee );
			entitymanager.close();
			emfactory.close();*/
			/*  ---------------------list of the User & use @NameQuery -------------------
			Query query = entitymanager.createNamedQuery("Categorie.findAll");
					List<Categorie> list=query.getResultList();
					for(Categorie e:list)
					{
					System.out.println("Id NAME :"+e.getCatId());
					System.out.println("Cat NAME :"+e.getCatFut());
					}
			/*  ---------------------Find user & use @NameQuery -------------------
			Query query = entitymanager.createNamedQuery(
					"Utilisteur.findAllId");
					query.setParameter("id", 1);
					List<Utilisteur> list = query.getResultList( );
					for( Utilisteur e:list )
					{
					System.out.print(" ID :"+e.getUser_Id ());
					System.out.println("\t  Name :"+e.getUser_Name());
					System.out.println("\t Employee Name :"+e.getUse_Pw());
					}*/
		System.out.println("Cat NAME :"+f.FindByName("qfqf"));
	}
}
