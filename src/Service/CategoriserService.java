package Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Dao.CategorieDAO;
import Dao.CategoriserDAO;
import model.Categoriser;

@Path("/Categoriser")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+"; charset=UTF-8")
public class CategoriserService {
	private Categoriser ModelCat = new Categoriser();
	private CategoriserDAO daoCatg = new CategoriserDAO();
	
    @GET
    @Path("/getall")
    public Response ListCategoriser() {
      
      return  Response
		 .status(200)
         .header("Access-Control-Allow-Origin", "*")
         .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
         .header("Access-Control-Allow-Credentials", "true")
         .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
         .header("Access-Control-Max-Age", "1209600")
         .entity(daoCatg.getAll())
         .build();
    }

}
