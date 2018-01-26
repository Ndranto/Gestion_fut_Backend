package Dao;
import java.util.List;

import javax.persistence.Query;
import javax.ws.rs.core.Response;

import model.*;

public class TypeDAO  extends GenericImplDAO<Type> implements GenericDAO<Type>{

	public ConnectionFactory daoFactory;

	@Override
	public List<Type> getAll() {
		
			this.QUeryName = "Type.findAll";
			return this.list();
		
	}

	@Override
	public List<Type> FindByListId(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Type> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Create(Type entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Type entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Object entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type findName(String Name) {
		daoFactory = new ConnectionFactory();
	    Query query = daoFactory.getEntityManager("Jax-rs_Gestion_Fut").createNamedQuery("Type.findAllName");
		query.setParameter("NameFut",Name);
		Type list = (Type) query.getSingleResult();
		return null;
	}

}
