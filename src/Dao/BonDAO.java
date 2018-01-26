package Dao;

import java.util.List;

import javax.ws.rs.core.Response;

import model.Bon;

public class BonDAO extends GenericImplDAO<Bon> implements GenericDAO<Bon>{

	@Override
	public List<Bon> getAll() {
		this.QUeryName = "Bon.findAll";
		return this.list();
	}

	@Override
	public List<Bon> FindByListId(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bon> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Create(Bon entite) {
		this.create(entite);
		return true;
	}

	@Override
	public boolean Update(Bon entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Object entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bon findName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

}
