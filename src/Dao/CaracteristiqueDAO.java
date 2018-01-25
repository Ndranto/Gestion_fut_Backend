package Dao;

import java.util.List;

import javax.ws.rs.core.Response;

import model.Caracteristique;

public class CaracteristiqueDAO extends GenericImplDAO<Caracteristique> implements GenericDAO<Caracteristique> {

	@Override
	public List<Caracteristique> getAll() {
	      this.QUeryName = "Caracteristique.findAll";
		return this.list();
	}

	@Override
	public List<Caracteristique> FindByListId(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caracteristique> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Create(Caracteristique entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Caracteristique entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Object entite) {
		// TODO Auto-generated method stub
		return false;
	}

}
