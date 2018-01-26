package Dao;

import java.util.List;

import javax.ws.rs.core.Response;

import model.Utiliser;

public class UtiliserDAO extends GenericImplDAO<Utiliser> implements GenericDAO<Utiliser> {

	@Override
	public List<Utiliser> getAll() {
		this.QUeryName = "Utiliser.findAll";
		return this.list();
	}

	@Override
	public List<Utiliser> FindByListId(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utiliser> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Create(Utiliser entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Utiliser entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Object entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utiliser findName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
