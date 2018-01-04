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
import Dao.TransportDAO;
import model.Transport;

@Path("/Transport")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class TransportService {
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;
    private TransportDAO daoTrans = new TransportDAO();
	/* List of product fut */
    @GET
    @Path("/ListTransport")
    public List<Transport>   ListTransport() {
    	
        return daoTrans.getAll();
    }
    
}
