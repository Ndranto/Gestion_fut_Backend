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
	public Response Create(Bon entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Update(Bon entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Delete(Object entite) {
		// TODO Auto-generated method stub
		return null;
	}

}
