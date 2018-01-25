package Service;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Dao.BonDAO;
import model.Bon;
import model.CatalogueFut;


@Path("/Bon")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class BonService {
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;
    private BonDAO dao = new BonDAO();
    private Bon modelBon = new Bon();
    @GET
    @Path("/list")
    public Response  BonList()
    {
    	return Response
    			 .status(200)
    		     .header("Access-Control-Allow-Origin", "*")
    		     .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
    		     .header("Access-Control-Allow-Credentials", "true")
    		     .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
    		     .header("Access-Control-Max-Age", "1209600")
    			    .entity(dao.getAll())
    			    .build();
    }
    
    @POST
    @Path("/addForm")
    @Consumes("application/x-www-form-urlencoded ")
    @Produces({ MediaType.TEXT_HTML })
    @Transactional
    public Response addForm(@FormParam("BonDate") Date BonDate,@FormParam("refBon") String refBon) throws Exception {
    	String json ="failed";
    	modelBon.setBonDate(BonDate);
    	modelBon.setRefBon(refBon);
    	modelBon.setBonValidation(true);
		if( dao.Create(modelBon) == true);
		{  json ="Success";
		 return Response
         		 .status(201)
   	            .header("Access-Control-Allow-Origin", "*")
   	            .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
   	            .header("Access-Control-Allow-Credentials", "true")
   	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
   	            .header("Access-Control-Max-Age", "1209600")
                .entity("Ajout: ")
                .build();
		}
			
		
    }

}
