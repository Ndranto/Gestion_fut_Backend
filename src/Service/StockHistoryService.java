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
import model.Stockage_History;
import Dao.StockHistDAO;

@Path("/HistorySTock")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class StockHistoryService {
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;
  Stockage_History stockage = new Stockage_History();
	StockHistDAO stockerdao  =  new StockHistDAO();
    public StockHistoryService() {
    
		super();
	
	}

	/* List of product fut */
    @GET
    @Path("/ListStocker")
    public List<Stockage_History>   ListStockage() {
        return stockerdao.getAll();
    }
}

