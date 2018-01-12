package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Client;
import Dao.ClientDAO;

@Path("/Client")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+"; charset=UTF-8")
public class ClientService {
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;

private Client modelClient;
private ClientDAO daoClient;

/* get all to list */
@GET
@Path("/ListClient")
public Response  ListVille() {
	daoClient = new ClientDAO();

   return Response
	 .status(200)
     .header("Access-Control-Allow-Origin", "*")
     .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
     .header("Access-Control-Allow-Credentials", "true")
     .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
     .header("Access-Control-Max-Age", "1209600")
    .entity(daoClient.getAll())
    .build();
}

/* find fut by Name */
@GET
@Path("/ClientName/{ClientName}")
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
public List<Client>   ListVilleName(@PathParam(value="ClientName")String ClientName) {
    return daoClient.FindByListName(ClientName);
}


/* find fut by Id */
@GET
@Path("/ClientId/{ClientId}")
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
public List<Client>   ListvilleId(@PathParam(value="ClientId")int ClientId) {
    return daoClient.FindByListId(ClientId);
}
	


/* add  new product */
@POST
@Path("/addClient")
public Response   AddVille(Client client)
{ 
	/* ecriture Json { "futId":2,"futDescrCatalogueFut": "lava","futNomCatalogueFut": "qsfqfs"}*/
	
	
	return daoClient.Create(client);
}
@PUT
@Path("/UpdateCLient")
@Consumes("application/x-www-form-urlencoded")
public Response Update() throws Exception {
    {   
    	modelClient = new Client();
    	modelClient.setCliIdClient(Integer.parseInt(request.getParameter("IdCli")));
    	modelClient.setCliNom(request.getParameter("NomClient"));
    	modelClient.setCliAdresse(request.getParameter("AdresseClient"));
    	modelClient.setCliSoldeClient(Integer.parseInt(request.getParameter("IdCli")));
    
        
        return daoClient.Update(modelClient);
    
    }
}
}
