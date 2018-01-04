package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import model.Caracteristique;
import Dao.CaracteristiqueDAO;


@Path("/Caracteristique")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class CaracteristiqueService {
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;
	Caracteristique CaracteristiqueModel = new Caracteristique();
	CaracteristiqueDAO caractdao  =  new CaracteristiqueDAO();

    public CaracteristiqueService() {
    
		super();
	
	}
    
	/* List of product Caracteristique */
    @GET
    @Path("/ListCaracteristique")
    public List<Caracteristique>   ListFut() {
        return caractdao.getAll();
    }
    

}
