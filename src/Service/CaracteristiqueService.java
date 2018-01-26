package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Caracteristique;
import model.Client;
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
    public Response  ListCaracteristique() {
        return  Response
		       .status(200)
               .header("Access-Control-Allow-Origin", "*")
               .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
               .header("Access-Control-Allow-Credentials", "true")
		       .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
		       .header("Access-Control-Max-Age", "1209600")
		       .entity(caractdao.getAll())
		       .build();
    }
    /* find fut by Name */
    @GET
    @Path("/caracteristique/{caractere}")
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    public Caracteristique   ListClientName(@PathParam(value="caractere")String caractere) {
        return caractdao.findName(caractere);
    }
    

}
