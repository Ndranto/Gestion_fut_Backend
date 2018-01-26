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
		this.parameter[1]="villeIdVille";
		this.QUeryName ="Ville.findAllId";
		return this.FindId((int) ValueidFut);
		
	}

	@Override
	public List<Ville> FindByListName(String Name) {
		this.parameter[1] = "villeNameVille";
		this.QUeryName =  "Ville.findAllName";
		return this.FindName(Name);
	}

	@Override
	public boolean Create(Ville entite) {
		 create(entite);
		 String json ="le Numero"+entite.getVilleIdVille()+"est Inserer";
	     return false;}

	@Override
	public boolean Update(Ville entite) {
		
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
		
			
		return  false;
	}

	@Override
	public boolean Delete(Object entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ville findName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

}
