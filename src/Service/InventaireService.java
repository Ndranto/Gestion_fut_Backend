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
import Dao.InventaireDAO;
import model.Inventaire;


@Path("/Inventaire")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class InventaireService {
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;
    
    private Inventaire Inventairemodel = new Inventaire();
    private InventaireDAO daoinventaire = new InventaireDAO();
	public InventaireService() {
		super();
	
	}
	
	/* List of product Caracteristique */
    @GET
    @Path("/ListInventaire")
    public List<Inventaire>   ListInventaire() {
        return daoinventaire.getAll();
    }
    
    

}
