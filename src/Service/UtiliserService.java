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
import model.Utiliser;
import Dao.UtiliserDAO;

@Path("/Utiliser")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class UtiliserService {
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;
    private UtiliserDAO daoTrans = new UtiliserDAO();
	/* List of product fut */
    @GET
    @Path("/TransportInventaire")
    public List<Utiliser>   ListUtiliser() {
        return daoTrans.getAll();
    }
}
