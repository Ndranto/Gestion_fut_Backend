package Dao;


import java.util.List;

import javafx.scene.control.Alert;

import javax.persistence.*;
import javax.ws.rs.core.Response;

import model.Inventaire;

public class SituationDAO extends GenericImplDAO<Inventaire> {

	public Response DetailFut() {
		String query = "SELECT li,year(li.inventaire.iinvDate) from  LigneInventaire li LEFT OUTER JOIN li.categorie categorie left JOIN li.inventaire inventaire left JOIN  inventaire.client client left JOIN  inventaire.caracteristique caracteristique  left JOIN li.stockage stockage left JOIN li.catalogueFut catalogueFut WHERE li.etatFut = "+false+" and YEAR(inventaire.iinvDate) = 2017";
		this.QUeryName = query;
		return null;
	}

	public List  SituationFutMagasin(String  etatFut ,int stockLieuStockage) {
		EntityManager em = this.getEntityManager();
		
		if(!etatFut.equals(""))
		{
		
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
							+ "GROUP BY stockage.ville.villeNameVille  YEAR(inventaire.iinvDate) = 2017";*/
		String Namequery = "SELECT  inv from Inventaire inv "
							+ "left join inv.categoriser cat "
							+ "left join cat.stockage stock "
							+ "where stock.stockId="+stockLieuStockage+" and cat.etat.etat_Name="+etatFut+"";
		Query query = em.createQuery(Namequery) ;
		return query.getResultList();
			
		
		}
		else{
			String Namequery = "SELECT  inv from Inventaire inv "
								+ "left join inv.categoriser cat "
								+ "left join cat.stockage stock "
								+ "where stock.stockId="+stockLieuStockage+" ";
			Query query = em.createQuery(Namequery) ;
			return query.getResultList();
		}

		
		/*query.setParameter("stockLieuStockage", stockLieuStockage);
		query.setParameter("etatFut", etatFut);*/
		
		
	}
	

	public List AchatFut(int Idcaracteristique) {
		EntityManager em = this.getEntityManager();
		String Namequery = "SELECT inv from  Inventaire inv "
						 + "left join inv.categoriser cat "
						 + "left join cat.bon bon "
						 + "left join bon.caracteristique "
						 + "Where bon.caracteristique.caraId="+Idcaracteristique+"";
		Query query = em.createQuery(Namequery) ;
		return query.getResultList();
		
	}
	public List SituationGeneralFut(String date) {
		EntityManager em = this.getEntityManager();
		String Namequery = "SELECT inv from  Inventaire inv  WHERE  YEAR(inv.iinvDate) = "+date+"";
		Query query = em.createQuery(Namequery) ;
		return query.getResultList();
	}
	
	public List SituationFut(String etatFut, int futId) {
		EntityManager em = this.getEntityManager();
		System.out.println(futId);
		if(!etatFut.equals(""))
		{
		String Namequery = "SELECT  inv from Inventaire inv "
				+ "left join inv.categoriser cat "
				+ "left join cat.stockage stock "
				+ "left join cat.catalogueFut fut "
				+ "where fut.futId="+futId+" and  cat.etat.etat_Name="+etatFut+"";
		Query query = em.createQuery(Namequery) ;
		return query.getResultList();
		}
		else{
			String Namequery = "SELECT  inv from Inventaire inv "
								+ "left join inv.categoriser cat "
								+ "left join cat.stockage stock "
								+ "left join cat.catalogueFut fut "
								+ "where fut.futId="+futId+"";
			Query query = em.createQuery(Namequery) ;
			return query.getResultList();
		}
	}
}
