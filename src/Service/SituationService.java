package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import Dao.SituationDAO;
import model.LigneInventaire;

@Path("/Situation")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class SituationService {
	SituationDAO dao = new SituationDAO();
    @GET
    @Path("/Magasin")
    public List<LigneInventaire>   ListFut(@QueryParam(value="Etat")boolean etat,@QueryParam(value="Magasin")String Magasin) {
        return dao.SituationFutMagasin(etat, Magasin);
    }
}
