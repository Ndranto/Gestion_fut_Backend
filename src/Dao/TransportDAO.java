package Dao;

import java.util.List;

import javax.ws.rs.core.Response;

import model.Transport;

public class TransportDAO extends GenericImplDAO<Transport> implements GenericDAO<Transport>{

	@Override
	public List<Transport> getAll() {
		this.QUeryName = "TransportAll";
		return this.list();
	}

	@Override
	public List<Transport> FindByListId(Object i) {
		this.QUeryName = "TransportAllId";
		this.id = "transId";
		return this.FindByListId(i);
	}

	@Override
	public List<Transport> FindByListName(String Name) {
		this.QUeryName = "TransportMatricule";
		this.id = "transIm";
		return this.FindByListName(Name);
	}

	@Override
	public Response Create(Transport entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Update(Transport entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Delete(Object entite) {
		// TODO Auto-generated method stub
		return null;
	}

}
