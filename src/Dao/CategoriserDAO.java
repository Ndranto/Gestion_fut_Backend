package Dao;

import java.util.List;

import javax.ws.rs.core.Response;
import model.Categoriser;

public class CategoriserDAO extends GenericImplDAO<Categoriser> implements GenericDAO<Categoriser>  {

	@Override
	public List<Categoriser> getAll() {
		this.QUeryName ="Categoriser.findAll";
		return this.list();
	}

	@Override
	public List<Categoriser> FindByListId(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoriser> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Create(Categoriser entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Update(Categoriser entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Delete(Object entite) {
		// TODO Auto-generated method stub
		return null;
	}

}
