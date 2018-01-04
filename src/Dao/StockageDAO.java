package Dao;

import java.util.List;

import javax.ws.rs.core.Response;

import model.Stockage;

public class StockageDAO extends GenericImplDAO<Stockage> implements GenericDAO<Stockage>{

	@Override
	public List<Stockage> getAll() {
		this.QUeryName ="Stockage.findAll";
		return this.list();
	}

	@Override
	public List<Stockage> FindByListId(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stockage> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Create(Stockage entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Update(Stockage entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Delete(Object entite) {
		// TODO Auto-generated method stub
		return null;
	}

}
