package Service;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import model.Categorie;
import model.Categories;
import Dao.CatalogueFut;


@Path("/fut")
@Stateless
@LocalBean
public class CatalogueFutService {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jax-rs_Gestion_Fut" );
	EntityManager entitymanager = emfactory.createEntityManager();
	CatalogueFut f = new CatalogueFut();
	private CatalogueFut Cataloguedao;
	@GET
	@Path("/categories")
	public String ConsulterCategories()  {
		
		return Cataloguedao.ListCategories();
	}
	
	
	
	/* List of category */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Listcategorie")
    public List<Categorie>   ListCategorie() {
    	Query query = entitymanager.createNamedQuery("Categorie.findAll");
		List<Categorie> list=query.getResultList();
        return list;
    }
    
    
    
    /* List of product fut */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Listfut")
    public List<CatalogueFut>   ListFut() {
    	Query query = entitymanager.createNamedQuery("CatalogueFut.findAll");
		List<CatalogueFut> list=query.getResultList();
        return list;
    }
    
    
}
