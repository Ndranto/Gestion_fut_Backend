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

import Dao.LigneInventaireDAO;
import model.LigneInventaire;

@Path("/LigneInventaire")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class LigneInventaireService {
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;
    private LigneInventaire ligneInvenataire =  new LigneInventaire();
    private LigneInventaireDAO daoLigneInventaire =  new LigneInventaireDAO();
	/* List of product Caracteristique */
    @GET
    @Path("/ListLigneInventaire")
    public List<LigneInventaire>   ListFut() {
        return daoLigneInventaire.getAll();
    }
}
