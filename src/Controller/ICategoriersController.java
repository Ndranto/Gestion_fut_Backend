package Controller;

import java.util.List;
import model.Categories;
import model.FutExample;

public interface ICategoriersController {
	public Categories addCatégorie (Categories C);
	public FutExample addFut(FutExample F);
	public List<Categories> ListCategories() ;
	public List<FutExample> listFutCat(Long idCategorie);
	public List<FutExample> listFut();
	public List<FutExample> listFutName(String Name);
	public Categories updateCategories(Categories C);
	public FutExample updateCategories(FutExample F);
	public boolean DeleteFuts(Long Fut_id);
	public Categories getCategorier(Long idCategories);
	public FutExample getFut(Long Fut_Id);
}
