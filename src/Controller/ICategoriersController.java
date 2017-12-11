package Controller;

import java.util.List;
import model.Categories;
import model.Fut;

public interface ICategoriersController {
	public Categories addCatégorie (Categories C);
	public Fut addFut(Fut F);
	public List<Categories> ListCategories() ;
	public List<Fut> listFutCat(Long idCategorie);
	public List<Fut> listFut();
	public List<Fut> listFutName(String Name);
	public Categories updateCategories(Categories C);
	public Fut updateCategories(Fut F);
	public boolean DeleteFuts(Long Fut_id);
	public Categories getCategorier(Long idCategories);
	public Fut getFut(Long Fut_Id);
}
