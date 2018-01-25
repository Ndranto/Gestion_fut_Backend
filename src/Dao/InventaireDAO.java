package Dao;

import java.util.List;


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
	public boolean Create(Inventaire entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Inventaire entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Object entite) {
		// TODO Auto-generated method stub
		return false;
	}

}
