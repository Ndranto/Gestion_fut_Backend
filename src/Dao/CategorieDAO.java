package Dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import model.Categorie;

public class CategorieDAO extends GenericImplDAO<Categorie> implements GenericDAO<Categorie> {
	public ConnectionFactory daoFactory;
	
	@Override
	public List<Categorie> getAll() {
		
		this.QUeryName ="Categorie.findAll";
		
		return this.list();
	}
	
	
	@Override
	public List<Categorie> FindByListId(Object i) {
		this.parameter ="catId";
		this.QUeryName ="Categorie.findAllId";
		return this.FindId(i);
	}

	@Override
	public List<Categorie> FindByListName(String Name) {
		this.parameter ="catFut";
		this.QUeryName ="Categorie.findAllName";
		return this.FindName(Name);
	}

	@Override
	public Response Create(Categorie entite) {
		Create(entite);
		String json ="le Numero"+entite.getCatId()+"est Inserer";
		return  Response.status(200).type("application/json").entity(json).build();
	}

	@Override
	public Response Update(Categorie entite) {
		  this.update(entite);
		  String json ="le Numero"+entite.getCatFut()+"est Modifier";
		return  Response.status(200).type("application/json").entity(json).build();
		}
	


	@Override
	public Response Delete(Object entite) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
