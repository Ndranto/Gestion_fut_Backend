package Service;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import Dao.CatalogueFutDAO;
import model.CatalogueFut;


@Path("/fut")
@Stateless
@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
public class CatalogueFutService {
	
	
	@Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;
	CatalogueFut fut = new CatalogueFut();
	CatalogueFutDAO catdao  =  new CatalogueFutDAO();;
	private CatalogueFut Catalogue;

    public CatalogueFutService() {
    
		super();
	
	}

	/* List of product fut */
    @GET
    @Path("/Listfut")
    public Response  ListFut() {
       
        return  Response
       		    .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(catdao.getAll())
                .build();
    }
    
    /* find the name of product fut */
    @GET
    @Path("/nameFut/{NameFut}")
    public List<CatalogueFut>   ListfutName(@PathParam(value="NameFut")String Name) {
        return catdao.FindByListName(Name);
        
    }
    
    
    
    /* find fut by Id */
    @GET
    @Path("/idFut/{IdFut}")
    public Response ListfutId(@PathParam(value="IdFut")int IdFut) {
      
      return  Response
		 .status(200)
         .header("Access-Control-Allow-Origin", "*")
         .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
         .header("Access-Control-Allow-Credentials", "true")
         .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
         .header("Access-Control-Max-Age", "1209600")
         .entity(catdao.FindByListId(IdFut))
         .build();
    }
    
    @GET
    @Path("/futName/{NameFut}")
    public CatalogueFut   FutName(@QueryParam(value="NameFut")String Name) {
        return catdao.FindByName(Name);
    }
    
    @GET
    @Path("/futId/{IdFut}")
    public CatalogueFut  FutId(@PathParam(value="IdFut")int IdFut) {
        return catdao.FindById(IdFut);
    }
    
    
    
      /* add  new product */
    @POST
    @Path("/add")
    public Response   AddFut(CatalogueFut fut)
    { 
    	/* ecriture Json { "futId":2,"futDescrCatalogueFut": "lava","futNomCatalogueFut": "qsfqfs"}*/
    	
    	
    	return catdao.Create(fut);
    }
    
    /* update  a product 
    @PUT
    @Path("/update")
    @Consumes("application/x-www-form-urlencoded")
    public Response   update()throws Exception 
    {  String id = request.getParameter("futId");
    String name = request.getParameter("futNomCatalogueFut");
    String descr = request.getParameter("futDescrCatalogueFut");
   int idfut = Integer.parseInt(id);
   Cataloguedao = new CatalogueFut();
    Cataloguedao.setFutId(idfut);
    Cataloguedao.setFutDescrCatalogueFut(descr);
    Cataloguedao.setFutNomCatalogueFut(name);
        return catdao.Update(fut);
    }*/
    @POST
    @Path("/addForm")
    @Consumes("application/x-www-form-urlencoded")
    public Response addForm() throws Exception {
      
    	Catalogue = new CatalogueFut();
    	Catalogue.setFutId((Integer.parseInt(request.getParameter("futId"))));
    	Catalogue.setFutDescrCatalogueFut(request.getParameter("futDescrCatalogueFut"));
    	Catalogue.setFutNomCatalogueFut(request.getParameter("futNomCatalogueFut"));
		return catdao.Create(Catalogue);
        
      
    }
    @PUT
    @Path("/Update")
    @Consumes("application/x-www-form-urlencoded")
    public Response Update() throws Exception {
        {    
        	Catalogue = new CatalogueFut();
        	Catalogue.setFutId((Integer.parseInt(request.getParameter("futId"))));
        	Catalogue.setFutDescrCatalogueFut(request.getParameter("futDescrCatalogueFut"));
        	Catalogue.setFutNomCatalogueFut(request.getParameter("futNomCatalogueFut"));
            
            return catdao.Update(Catalogue);
        
        }
    }
    
    
    /*Delete Product */
    @DELETE
    @Path("/Delete/{IdFut}")
    public  Response  Delete(@PathParam(value="IdFut")int IdFut)
    	{
    
        return   catdao.Delete(IdFut);
    	}
 
    
    
    
    @GET
    @Path("/string")
    public Response  getstring()
    	{
    	String json ="Succes";
    	  return Response
         		 .status(200)
  	            .header("Access-Control-Allow-Origin", "*")
  	            .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
  	            .header("Access-Control-Allow-Credentials", "true")
  	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
  	            .header("Access-Control-Max-Age", "1209600")
                 .entity("getUser() user-agent: " + json)
                 .build();
    	}
    
    																									
    @GET
    public Response getUser(@Context HttpHeaders headers){
    	
        String userAgent = headers.getRequestHeader("user-agent").get(0);

        return Response
        		 .status(200)
 	            .header("Access-Control-Allow-Origin", "*")
 	            .header("Access-Control-Allow-Headers", "origin, content-Type, accept, authorization")
 	            .header("Access-Control-Allow-Credentials", "true")
 	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
 	            .header("Access-Control-Max-Age", "1209600")
                .entity("getUser() user-agent: " + userAgent)
                .build();
    }
    }
