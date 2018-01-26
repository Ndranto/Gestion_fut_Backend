package Dao;

import java.util.List;

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
		this.parameter = new String[1];
		this.parameter[0] ="catId";
		this.QUeryName ="Categorie.findAllId";
		return this.FindId(i);
	}

	@Override
	public List<Categorie> FindByListName(String Name) {
		this.parameter = new String[1];
		this.parameter[0] ="catFut";
		this.QUeryName ="Categorie.findAllName";
		return this.FindName(Name);
	}

	@Override
	public boolean Create(Categorie entite) {
		Create(entite);
		String json ="le Numero"+entite.getCatId()+"est Inserer";
		return false;
	}

	@Override
	public boolean Update(Categorie entite) {
		  this.update(entite);
		  String json ="le Numero"+entite.getCatFut()+"est Modifier";
		return  false;
		}
	


	@Override
	public boolean Delete(Object entite) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Categorie findName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
