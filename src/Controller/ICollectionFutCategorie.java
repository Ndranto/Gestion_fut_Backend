package Controller;

import java.util.List;

import model.Categorie;
import model.CatalogueFut;;


public interface ICollectionFutCategorie {



	public Categorie addCatégorie (Categorie C);
	public CatalogueFut addFut(CatalogueFut F);
	public List<Categorie> ListCategories() ;
	public  List<CatalogueFut> listFutCategorie(Integer idCategorie);
	public List<CatalogueFut> listFut();
	public List<CatalogueFut> listFutName(String Name);
	public Categorie updateCategories(Categorie C);
	public CatalogueFut updateCategories(CatalogueFut F);
	public boolean DeleteFuts(Integer Fut_id);
	public Categorie getCategorier(Integer idCategories);
	public CatalogueFut getFut(Integer Fut_Id);
}


