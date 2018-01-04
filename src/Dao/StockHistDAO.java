package Dao;

import java.util.List;

import javax.ws.rs.core.Response;

import model.Stockage_History;

public class StockHistDAO extends GenericImplDAO<Stockage_History> implements GenericDAO<Stockage_History> {

	@Override
	public List<Stockage_History> getAll() {
		this.QUeryName ="Stockage_History.findAll";
		return this.list();
	}

	@Override
	public List<Stockage_History> FindByListId(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stockage_History> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Create(Stockage_History entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Update(Stockage_History entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Delete(Object entite) {
		// TODO Auto-generated method stub
		return null;
	}

}
