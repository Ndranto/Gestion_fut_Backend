package Service;



import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import model.Categorie;
import Dao.CatalogueFut;


@Path("/fut")
@Stateless
@LocalBean
public class CatalogueFutService {
	
    @PersistenceContext(unitName="Jax-rs_Gestion_Fut", type=PersistenceContextType.TRANSACTION)
    EntityManager entityManager;
	private CatalogueFut Cataloguedao;
	@GET
	@Path("/categories")
	public String ConsulterCategories()  {
		
		return Cataloguedao.ListCategories();
	}
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/LIST")
    public List<Categorie>  findCustomersByCity() {
        Query query = entityManager.createNamedQuery("Categorie.findAll");
    
        return query.getResultList();
    }
}
