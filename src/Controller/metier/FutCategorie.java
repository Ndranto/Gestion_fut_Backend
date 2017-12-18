package Controller.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.CatalogueFut;
import model.Categorie;
import model.Categories;
import model.FutExample;
import Controller.ICollectionFutCategorie;

public class FutCategorie implements ICollectionFutCategorie {
	
	private Map<Integer, Categorie> categories = new HashMap<Integer, Categorie>();
	private Map<Integer, CatalogueFut> fut = new HashMap<Integer, CatalogueFut>();

	@Override
	public Categorie addCatégorie(Categorie C) {
		categories.put(C.getCatId(), C );
		return C;
	}

	@Override
	public CatalogueFut addFut(CatalogueFut F) {
		fut.put(F.getFutId(), F);
		return F;
	}

	@Override
	public List<Categorie> ListCategories() {
		return new ArrayList<Categorie>(categories.values());
	}

	@Override
	public List<CatalogueFut> listFutCategorie(Integer idCategorie) {
         
	/*	List<CatalogueFut> futCategorie = new ArrayList<CatalogueFut>();
		
		for(CatalogueFut ft:fut.values())
		{
			if(ft.getCategorie().getCatId().equals(idCategorie));
			futCategorie.add(ft);
		}*/
		return null;
	}

	@Override
	public List<CatalogueFut> listFut() {
		// TODO Auto-generated method stub
		return new ArrayList<CatalogueFut>(fut.values());
	}

	@Override
	public List<CatalogueFut> listFutName(String Name) {
		List<CatalogueFut> FutName = new ArrayList<CatalogueFut>();
		for (CatalogueFut futExample : fut.values()) {
			if(futExample.getFutNomCatalogueFut().contains(Name))
				{FutName.add(futExample);}
		}
			return FutName;
	}

	@Override
	public Categorie updateCategories(Categorie C) {
		categories.put(C.getCatId(), C);
		return C;
	}

	@Override
	public CatalogueFut updateCategories(CatalogueFut F) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean DeleteFuts(Integer Fut_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Categorie getCategorier(Integer idCategories) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CatalogueFut getFut(Integer Fut_Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
