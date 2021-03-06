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
import model.Stocker;
import Dao.StockerDAO;

@Path("/Stocker")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class StockerService {
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;
	Stocker stockage = new Stocker();
	StockerDAO stockerdao  =  new StockerDAO();;
	public StockerService() {
    
		super();
	
	}

	/* List of product fut */
    @GET
    @Path("/ListStocker")
    public List<Stocker>   ListStockage() {
        return stockerdao.getAll();
    }
}
