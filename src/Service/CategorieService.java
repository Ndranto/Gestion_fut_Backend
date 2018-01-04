package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Dao.CategorieDAO;
import model.Categorie;


@Path("/Categorie")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+"; charset=UTF-8")
public class CategorieService {
	CategorieDAO catdao= new CategorieDAO(); 
	Categorie categorie = new Categorie();
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;
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
    @POST
    @Path("/add")
    public Response   AddFut(Categorie categ)
    { 
    	/* ecriture Json { "futId":2,"futDescrCatalogueFut": "lava","futNomCatalogueFut": "qsfqfs"}*/
    	
    	
    	return catdao.Create(categ);
    }
    @POST
    @Path("/addForm")
    @Consumes("application/x-www-form-urlencoded")
    public Response addForm() throws Exception {
      
    	
    	categorie.setCatFut(request.getParameter("CategorieFut"));
    	categorie.setCatId(Integer.parseInt(request.getParameter("futDescrCatalogueFut")));

		return catdao.Create(categorie);
        
      
    }
    @PUT
    @Path("/Update")
    @Consumes("application/x-www-form-urlencoded")
    public Response Update() throws Exception {
        {   
        	categorie.setCatId(Integer.parseInt(request.getParameter("CatId")));
        	categorie.setCatFut(request.getParameter("CatFut")); 
            return catdao.Update(categorie);
        
        }
        
        
        
    }
    @GET
    @Path("/namecategorie/{CategorieName}")
    public List<Categorie>   ListCategorieName(@PathParam(value="CategorieName")String Name) {
        return catdao.FindByListName(Name);
    }
    
    
}
