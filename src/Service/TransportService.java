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
    public Response  ListTransport() {
    	
        
        return Response
        		 .status(200)
 	            .header("Access-Control-Allow-Origin", "*")
 	            .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
 	            .header("Access-Control-Allow-Credentials", "true")
 	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
 	            .header("Access-Control-Max-Age", "1209600")
                .entity(daoTrans.getAll())
                .build();
    }
    
}
