package Dao;

import java.util.List;

import javax.ws.rs.core.Response;

import model.Inventaire;

public class InventaireDAO  extends GenericImplDAO<Inventaire> implements GenericDAO<Inventaire>{

	@Override
	public List<Inventaire> getAll() {
		this.QUeryName = "Inventaire.findAll";
		return this.list();
	}

	@Override
	public List<Inventaire> FindByListId(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventaire> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Create(Inventaire entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Update(Inventaire entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Delete(Object entite) {
		// TODO Auto-generated method stub
		return null;
	}

}
