package Controller.metier;

import java.util.*;
import model.Categories;
import model.Fut;
import Controller.ICategoriersController;

public class CategoriesFut implements ICategoriersController {
    
	private Map<Long, Categories> categories = new HashMap<Long, Categories>();
	private Map<Long, Fut> fut = new HashMap<Long, Fut>();
	
	@Override
	public Categories addCatégorie(Categories C) {
		categories.put(C.getIdCategorie(), C);
		return C;
	}

	@Override
	public Fut addFut(Fut F) {
	    F.setCategorie(getCategorier(F.getCategorie().getIdCategorie()));
		fut.put(F.getFut_Id(), F);
		return F;
	}

	@Override
	public List<Categories> ListCategories() {
		
		return new ArrayList<Categories>(categories.values());
	}

	@Override
	public List<Fut> listFutCat(Long idCategorie) {
		List<Fut> futs = new ArrayList<Fut>();
		
		for(Fut ft:fut.values())
		{
			if(ft.getCategorie().getIdCategorie().equals(idCategorie))
			futs.add(ft);
		}
		return futs;
	}

	@Override
	public List<Fut> listFut() {
		// TODO Auto-generated method stub
		return new ArrayList<Fut>(fut.values());
	}

	@Override
	public List<Fut> listFutName(String Name) {
		List<Fut> FutName = new ArrayList<Fut>();
	for (Fut fut : fut.values()) {
		if(fut.getFut_Name().contains(Name))
			{FutName.add(fut);}
	}
		return FutName;
	}

	@Override
	public Categories updateCategories(Categories C) {
		categories.put(C.getIdCategorie(), C);
		return C;
	}

	@Override
	public Fut updateCategories(Fut F) {
	      fut.put(F.getFut_Id(), F);
		return F;
	}

	@Override
	public boolean DeleteFuts(Long Fut_id) {
		if(fut.get(Fut_id)!=null)
		{
			fut.remove(Fut_id);
			return true;
		}
		else throw new RuntimeException("Fut Introuveble");
	}

	@Override
	public model.Categories getCategorier(Long idCategories) {
		// TODO Auto-generated method stub
		return categories.get(idCategories);
	}

	@Override
	public model.Fut getFut(Long Fut_Id) {
		// TODO Auto-generated method stub
		return fut.get(Fut_Id) ;
	}
	public void Initialise()
	{
		addCatégorie(new Categories(1L, "bon", "photo1.JPG"));
		addCatégorie(new Categories(2L, "Mauvais", "photo2.JPG"));
		addCatégorie(new Categories(3L, "Cassée", "photo3.JPG"));
	
		fut.put(1L, new Fut(1L, "10,5l Lava", true, getCategorier(1L)));
		fut.put(2L, new Fut(2L, "Grays", true, getCategorier(2L)));
		fut.put(3L, new Fut(3L, "10.5 Croisé", true, getCategorier(1L)));
	
		
	}

}
