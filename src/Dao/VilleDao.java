package Dao;

import java.util.List;

import javax.ws.rs.core.Response;
import model.Ville;

public class VilleDao extends GenericImplDAO<Ville> implements GenericDAO<Ville> {

	@Override
	public List<Ville> getAll() {
		this.QUeryName = "Ville.findAll";
		return this.list();
		}

	@Override
	public List<Ville> FindByListId(Object ValueidFut) {
		this.parameter ="villeIdVille";
		this.QUeryName ="Ville.findAllId";
		return this.FindId((int) ValueidFut);
		
	}

	@Override
	public List<Ville> FindByListName(String Name) {
		this.parameter = "villeNameVille";
		this.QUeryName =  "Ville.findAllName";
		return this.FindName(Name);
	}

	@Override
	public Response Create(Ville entite) {
		 create(entite);
		 String json ="le Numero"+entite.getVilleIdVille()+"est Inserer";
	     return  Response.status(200).type("application/json").entity(json).build();
	}

	@Override
	public Response Update(Ville entite) {
		
		   this.update(entite);
			/* EntityManagerFactory factory = getEntityManagerFactory();
				EntityManager entitym = getEntityManager();
				
				entitym.getTransaction().begin();
				CatalogueFut cat  = entitym.find(CatalogueFut.class,Fut.getFutId());
				cat.setFutDescrCatalogueFut(Fut.getFutDescrCatalogueFut());
				cat.setFutNomCatalogueFut(Fut.getFutNomCatalogueFut());
				entitym.getTransaction().commit();
				entitym.close();
				factory.close();*/ 
			String json ="le Numero"+entite.getVilleIdVille()+"est Modifier";
		
			
		return  Response.status(200).type("application/json").entity(json).build();
	}

	@Override
	public Response Delete(Object entite) {
		// TODO Auto-generated method stub
		return null;
	}

}
