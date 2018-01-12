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
import javax.ws.rs.core.Response;

import model.Stockage;
import Dao.StockageDAO;

@Path("/Stockage")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class StockageService {
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;
	Stockage stockage = new Stockage();
	StockageDAO stockagedao  =  new StockageDAO();;
	public StockageService() {
    
		super();
	
	}

	/* List of product fut */
    @GET
    @Path("/ListStockage")
    public Response  ListStockage() {
        
        
        return  Response
       		    .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(stockagedao.getAll())
                .build();
    }

}
