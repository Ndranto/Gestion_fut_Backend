package Service;

import javax.ws.rs.core.*;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import model.Categorie;
import model.Categories;
import model.FutExample;
import Controller.metier.CategoriesFut;
import Dao.CatalogueFutDAO;

@Path("/Catalogue")
@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
public class CatalogueServices {
private CategoriesFut cat;
private CatalogueFutDAO Cataloguedao;

public CatalogueServices() {
	cat = new CategoriesFut();
	cat.Initialise();
}
@GET
@Path("/categories")
public List<Categorie> ConsulterCategories(){
	return Cataloguedao.getAll();
}
@GET
@Path("/Categorie/{idcat}/fut")
public List<FutExample> CategorieFut(@PathParam(value ="idcat")Long idcat){
	return cat.listFutCat(idcat);
}
@GET
@Path("/																																																																																																		")
public List<FutExample> ListFut(@QueryParam(value ="Futname")String Futname){
	return cat.listFutName(Futname);
}
@GET
@Path("/categories/{idCat}")
public Categories GetCategories(@PathParam(value="idCat")Long idCat){
	return cat.getCategorier(idCat);
}
@GET
@Path("/FutExample/{Fut_Id}")
public FutExample GetFut(@PathParam(value="Fut_Id")Long Fut_Id){
	return cat.getFut(Fut_Id);
}
@GET
@Path("/addCategorie")
//@Consumes(MediaType.APPLICATION_JSON+"; charset=utf-8")
public Categories SaveCategories(Categories c) {
	return cat.addCatégorie(c);
}
}
