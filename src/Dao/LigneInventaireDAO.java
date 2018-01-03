package Dao;

import java.util.List;

import javax.ws.rs.core.Response;

import model.LigneInventaire;

public class LigneInventaireDAO extends GenericImplDAO<LigneInventaire> implements GenericDAO<LigneInventaire>  {

	@Override
	public List<LigneInventaire> getAll() {
		this.QUeryName = "CatalogueFut.findAll";
		return this.list();
	}

	@Override
	public List<LigneInventaire> FindByListId(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LigneInventaire> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Create(LigneInventaire entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Update(LigneInventaire entite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response Delete(Object entite) {
		// TODO Auto-generated method stub
		return null;
	}

}
