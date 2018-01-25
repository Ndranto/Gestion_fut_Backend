package Dao;

import java.util.List;

import javax.ws.rs.core.Response;

import model.LigneInventaire;

public class LigneInventaireDAO extends GenericImplDAO<LigneInventaire> implements GenericDAO<LigneInventaire>  {

	@Override
	public List<LigneInventaire> getAll() {
		this.QUeryName = "LigneInventaire";
		return this.list();
	}

	@Override
	public List<LigneInventaire> FindByListId(Object i) {
		
		return null;
	}
    
	
	public List<LigneInventaire> ListFutPleinSortie(Object[] i) {
		this.parameter = new String[2];
		this.parameter[0] = "invType";
		this.QUeryName = "LigneInvSituation";
		return FindJoint(i) ;
	}
	
	public List<LigneInventaire> ListFutPleineEntrer(Object i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<LigneInventaire> ListFutVideSortie(Object i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<LigneInventaire> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Create(LigneInventaire entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(LigneInventaire entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Object entite) {
		// TODO Auto-generated method stub
		return false;
	}

}
