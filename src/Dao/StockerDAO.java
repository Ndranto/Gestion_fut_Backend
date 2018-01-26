package Dao;

import java.util.List;

import javax.ws.rs.core.Response;

import model.Stocker;

public class StockerDAO extends GenericImplDAO<Stocker>implements GenericDAO<Stocker> {

	@Override
	public List<Stocker> getAll() {
		this.QUeryName = "Stocker.findAll";
		return this.list();
	}

	@Override
	public List<Stocker> FindByListId(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stocker> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Create(Stocker entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Stocker entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Object entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Stocker findName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

}
