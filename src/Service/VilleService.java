package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.VilleDao;
import model.Ville;

@Path("/Ville")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+"; charset=UTF-8")

public class VilleService {
	
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;

private Ville modelville;
private VilleDao daoville;

/* get all to list */
@GET
@Path("/ListVille")
public List<Ville>   ListVille() {
	daoville = new VilleDao();
    return daoville.getAll();
}

/* find fut by Name */
@GET
@Path("/villename/{villeNameVille}")
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
public List<Ville>   ListVilleName(@PathParam(value="villeNameVille")String villeNameVille) {
    return daoville.FindByListName(villeNameVille);
}


/* find fut by Id */
@GET
@Path("/villeid/{villeIdVille}")
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
public List<Ville>   ListvilleId(@PathParam(value="villeIdVille")int villeIdVille) {
    return daoville.FindByListId(villeIdVille);
}
	


/* add  new product */
@POST
@Path("/add")
public Response   AddVille(Ville fut)
{ 
	/* ecriture Json { "futId":2,"futDescrCatalogueFut": "lava","futNomCatalogueFut": "qsfqfs"}*/
	
	
	 daoville.Create(fut);
	return   Response
     		 .status(201)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
    .entity("Ajout: " )
    .build();
}
@PUT
@Path("/Update")
@Consumes("application/x-www-form-urlencoded")
public Response Update() throws Exception {
    {   
    	modelville = new Ville();
    	modelville.setVilleIdVille(Integer.parseInt(request.getParameter("Id")));
    	modelville.setVilleNameVille(request.getParameter("Nom"));
    
        
         daoville.Update(modelville);
        return  Response
         		 .status(201)
   	            .header("Access-Control-Allow-Origin", "*")
   	            .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
   	            .header("Access-Control-Allow-Credentials", "true")
   	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
   	            .header("Access-Control-Max-Age", "1209600")
          .entity("Ajout: " )
          .build();
    
    }
}
}
