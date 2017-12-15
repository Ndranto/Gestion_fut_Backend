package Controller.metier;

import java.util.*;
import model.Categories;
import model.FutExample;
import Controller.ICategoriersController;

public class CategoriesFut implements ICategoriersController {
    
	private Map<Long, Categories> categories = new HashMap<Long, Categories>();
	private Map<Long, FutExample> futExample = new HashMap<Long, FutExample>();
	
	@Override
	public Categories addCatégorie(Categories C) {
		categories.put(C.getIdCategorie(), C);
		return C;
	}

	@Override
	public FutExample addFut(FutExample F) {
	    F.setCategorie(getCategorier(F.getCategorie().getIdCategorie()));
		futExample.put(F.getFut_Id(), F);
		return F;
	}

	@Override
	public List<Categories> ListCategories() {
		
		return new ArrayList<Categories>(categories.values());
	}

	@Override
	public List<FutExample> listFutCat(Long idCategorie) {
		List<FutExample> futExamples = new ArrayList<FutExample>();
		
		for(FutExample ft:futExample.values())
		{
			if(ft.getCategorie().getIdCategorie().equals(idCategorie))
			futExamples.add(ft);
		}
		return futExamples;
	}

	@Override
	public List<FutExample> listFut() {
		// TODO Auto-generated method stub
		return new ArrayList<FutExample>(futExample.values());
	}

	@Override
	public List<FutExample> listFutName(String Name) {
		List<FutExample> FutName = new ArrayList<FutExample>();
	for (FutExample futExample : futExample.values()) {
		if(futExample.getFut_Name().contains(Name))
			{FutName.add(futExample);}
	}
		return FutName;
	}

	@Override
	public Categories updateCategories(Categories C) {
		categories.put(C.getIdCategorie(), C);
		return C;
	}

	@Override
	public FutExample updateCategories(FutExample F) {
	      futExample.put(F.getFut_Id(), F);
		return F;
	}

	@Override
	public boolean DeleteFuts(Long Fut_id) {
		if(futExample.get(Fut_id)!=null)
		{
			futExample.remove(Fut_id);
			return true;
		}
		else throw new RuntimeException("FutExample Introuveble");
	}

	@Override
	public model.Categories getCategorier(Long idCategories) {
		// TODO Auto-generated method stub
		return categories.get(idCategories);
	}

	@Override
	public model.FutExample getFut(Long Fut_Id) {
		// TODO Auto-generated method stub
		return futExample.get(Fut_Id) ;
	}
	public void Initialise()
	{
		addCatégorie(new Categories(1L, "bon", "photo1.JPG"));
		addCatégorie(new Categories(2L, "Mauvais", "photo2.JPG"));
		addCatégorie(new Categories(3L, "Cassée", "photo3.JPG"));
	
		futExample.put(1L, new FutExample(1L, "10,5l Lava", true, getCategorier(1L)));
		futExample.put(2L, new FutExample(2L, "Grays", true, getCategorier(2L)));
		futExample.put(3L, new FutExample(3L, "10.5 Croisé", true, getCategorier(1L)));
	
		
	}

}
