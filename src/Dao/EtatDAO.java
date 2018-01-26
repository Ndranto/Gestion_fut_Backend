package Dao;

import java.util.List;

import javax.ws.rs.core.Response;

import model.Etat;

public class EtatDAO extends GenericImplDAO<Etat> implements GenericDAO<Etat> {

	@Override
	public List<Etat> getAll() {
		this.QUeryName = "Etat.findAll";
		return this.list();
	}

	@Override
	public List<Etat> FindByListId(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Etat> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Create(Etat entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Etat entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Object entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Etat findName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

}
