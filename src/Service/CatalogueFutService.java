package Service;



import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import Dao.CatalogueFutDAO;
import model.Categorie;
import model.CatalogueFut;


@Path("/fut")
@Stateless
@LocalBean
@Produces(MediaType.APPLICATION_JSON+"; charset=UTF-8")
public class CatalogueFutService {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut" );
	EntityManager entitymanager = emfactory.createEntityManager();
	CatalogueFut f = new CatalogueFut();
	CatalogueFutDAO catdao;
	private CatalogueFut Cataloguedao;

	
	
	/* List of category */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Listcategorie")
    public List<Categorie>   ListCategorie() {
    	Query query = entitymanager.createNamedQuery("Categorie.findAll");
		List<Categorie> list=query.getResultList();
        return catdao.getAll();
    }
    
    
    
    /* List of product fut */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Listfut")
    public List<CatalogueFut>   ListFut() {
    	catdao = new CatalogueFutDAO();
        return catdao.getAll();
    }
    
    /* find the name of product fut */
    @GET
    @Path("/Listfut/{NameFut}")
    public List<CatalogueFut>   ListfutName(@PathParam(value="NameFut")String Name) {
    	catdao = new CatalogueFutDAO();
        return catdao.FindByName(Name);
    }
    
}
