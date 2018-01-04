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
    public List<Stockage>   ListStockage() {
        return stockagedao.getAll();
    }

}
