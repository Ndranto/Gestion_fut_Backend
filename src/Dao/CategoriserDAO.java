package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import model.Categoriser;

public class CategoriserDAO extends GenericImplDAO<Categoriser> implements GenericDAO<Categoriser>  {

	@Override
	public List<Categoriser> getAll() {
		this.QUeryName ="Categoriser.findAll";
		return this.list();
	}

	@Override
	public List<Categoriser> FindByListId(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoriser> FindByListName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Create(Categoriser entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Categoriser entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(Object entite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Categoriser findName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}
	public List DetailsFutActuel(String etatFut, int futId) {
		EntityManager em = this.getEntityManager();
		System.out.println(futId);
		if(!etatFut.equals(""))
		{
		String Namequery = "SELECT cat from Categoriser cat "
							+ "left join cat.stockage stock "
							+ "left join cat.catalogueFut fut "
							+ "where fut.futId="+futId+" and  cat.etat.etat_Name="+etatFut+" group by stock.stockLieuStockage";
		Query query = em.createQuery(Namequery) ;
		return query.getResultList();
		}
		else{
			String Namequery = "SELECT cat from Categoriser cat "
								+ "left join cat.stockage stock "
								+ "left join cat.catalogueFut fut "
								+ "where fut.futId="+futId+"";
			Query query = em.createQuery(Namequery) ;
			return query.getResultList();
		}
	}

}
