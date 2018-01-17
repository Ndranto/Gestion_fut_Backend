package Dao;


import java.util.List;

import javax.persistence.*;
import javax.ws.rs.core.Response;

import model.Inventaire;

public class SituationDAO extends GenericImplDAO<Inventaire> {

	public Response DetailFut() {
		String query = "SELECT li,year(li.inventaire.iinvDate) from  LigneInventaire li LEFT OUTER JOIN li.categorie categorie left JOIN li.inventaire inventaire left JOIN  inventaire.client client left JOIN  inventaire.caracteristique caracteristique  left JOIN li.stockage stockage left JOIN li.catalogueFut catalogueFut WHERE li.etatFut = "+false+" and YEAR(inventaire.iinvDate) = 2017";
		this.QUeryName = query;
		return null;
	}

	public List  SituationFutMagasin(boolean etatFut ,String stockLieuStockage) {
		EntityManager em = this.getEntityManager();
	/*	String Namequery = "SELECT li  from  LigneInventaire li "
							+ "left JOIN li.inventaire inventaire "
							+ "left JOIN li.stockage stockage  "
							+ "left JOIN li.categoriser categoriser "
							+ "left JOIN  inventaire.client client "
							+ "left JOIN  inventaire.caracteristique caracteristique"
							+ "left JOIN categoriser.transport "
							+ "left JOIN categoriser.catalogueFut "        
							+ "WHERE li.etat_Fut = :etatFut and "
							+ "stockage.ville.villeNameVille = :stockLieuStockage "
							+ "GROUP BY stockage.ville.villeNameVille";*/
		String Namequery = "SELECT  sum(qtefut) from Categoriser categoriser "
				+ " LEFT JOIN  categoriser.stockage stockage"
				+ " Left join stockage.ville ville  "
				+ " where stockage.ville.VilleIdVille =1 "
				+ " group by  stockage.ville.VilleIdVille ";
		Query query = em.createQuery(Namequery) ;
		/*query.setParameter("stockLieuStockage", stockLieuStockage);
		query.setParameter("etatFut", etatFut);*/
		return query.getResultList();
	}
	

	public Response AchatFut() {
		String query = "SELECT li,year(li.inventaire.iinvDate) from  LigneInventaire li LEFT OUTER JOIN li.categorie categorie left JOIN li.inventaire inventaire left JOIN  inventaire.client client left JOIN  inventaire.caracteristique caracteristique  left JOIN li.stockage stockage left JOIN li.catalogueFut catalogueFut WHERE li.etatFut = "+false+" and YEAR(inventaire.iinvDate) = 2017";
		this.QUeryName = query;
		return null;
	}
	public Response SItuationGeneralFut() {
		String query = "SELECT li,year(li.inventaire.iinvDate) from  LigneInventaire li LEFT OUTER JOIN li.categorie categorie left JOIN li.inventaire inventaire left JOIN  inventaire.client client left JOIN  inventaire.caracteristique caracteristique  left JOIN li.stockage stockage left JOIN li.catalogueFut catalogueFut WHERE li.etatFut = "+false+" and YEAR(inventaire.iinvDate) = 2017";
		this.QUeryName = query;
		return null;
	}
}
