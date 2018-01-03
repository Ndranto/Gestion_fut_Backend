package Dao;

import java.util.List;

import javax.ws.rs.core.Response;

import model.Client;

public class ClientDAO  extends GenericImplDAO<Client> implements GenericDAO<Client> {
	@Override
	public List<Client> getAll() {
		this.QUeryName = "Client.findAll";
		return this.list();
		}

	@Override
	public List<Client> FindByListId(Object ValueidFut) {
		this.parameter ="cliIdClient	";
		this.QUeryName ="Client.findAllId";
		return this.FindId((int) ValueidFut);
		
	}

	@Override
	public List<Client> FindByListName(String Name) {
		this.parameter = "cliNom";
		this.QUeryName =  "Client.findAllName";
		return this.FindName(Name);
	}

	@Override
	public Response Create(Client entite) {
		 create(entite);
		 String json ="le Numero"+entite.getCliIdClient()+"est Inserer";
	     return  Response.status(200).type("application/json").entity(json).build();
	}

	@Override
	public Response Update(Client entite) {
		
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
			String json ="le Numero"+entite.getCliIdClient()+"est Modifier";
		
			
		return  Response.status(200).type("application/json").entity(json).build();
	}

	@Override
	public Response Delete(Object entite) {
		// TODO Auto-generated method stub
		return null;
	}

}
