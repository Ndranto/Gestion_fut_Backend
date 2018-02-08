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
import javax.ws.rs.core.Response;

import Dao.SituationDAO;
import model.Inventaire;
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
    public Response  ListFut(@QueryParam(value="Etat")String etat,@QueryParam(value="Magasin")int Magasin) {
        return 
        Response
		    .status(200)
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
        .header("Access-Control-Allow-Credentials", "true")
        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
        .header("Access-Control-Max-Age", "1209600")
        .entity(dao.SituationFutMagasin(etat, Magasin))
        .build();
    }
    
    @GET
    @Path("/Achat")
    public Response  Achat(@QueryParam(value="Etat")String etat,@QueryParam(value="Achat")int achat) {
     
        return 
                Response
        		    .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(dao.AchatFut(achat))
                .build();
    }
    @GET
    @Path("/SituationGeneral")
    public Response   SituationGeneral(@QueryParam(value="date")String Date) {
     
        return 
                Response
        		    .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity( dao.SituationGeneralFut(Date))
                .build();
    }
    
    @GET
    @Path("/SituationFut")
    public Response  SituationFut(@QueryParam(value="etatFut")String etatFut,@QueryParam(value="futId")int futId) {
       
        return 
                Response
        		    .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(dao.SituationFut(etatFut,futId))
                .build();
    }
}
