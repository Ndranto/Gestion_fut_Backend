package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Dao.CategorieDAO;
import model.Categorie;


@Path("/Categorie")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+"; charset=UTF-8")
public class CategorieService {
	CategorieDAO catdao= new CategorieDAO(); 
	
	
	
	public CategorieService() {
		
		super();
		
		// TODO Auto-generated constructor stub
	}

	/* List of category */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Listcategorie")
    public List<Categorie>   ListCategorie() {
        return catdao.getAll();
    }
    

}
