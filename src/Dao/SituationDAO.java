package Dao;

import javax.ws.rs.core.Response;

import model.Inventaire;

public class SituationDAO extends GenericImplDAO<Inventaire> {

	public Response DetailFut() {
		String query = "SELECT li,year(li.inventaire.iinvDate) from  LigneInventaire li LEFT OUTER JOIN li.categorie categorie left JOIN li.inventaire inventaire left JOIN  inventaire.client client left JOIN  inventaire.caracteristique caracteristique  left JOIN li.stockage stockage left JOIN li.catalogueFut catalogueFut WHERE li.etatFut = "+false+" and YEAR(inventaire.iinvDate) = 2017";
		this.QUeryName = query;
		return null;
	}

	public Response SituationFutMagasin() {
		String query = "SELECT li,year(li.inventaire.iinvDate) from  LigneInventaire li LEFT OUTER JOIN li.categorie categorie left JOIN li.inventaire inventaire left JOIN  inventaire.client client left JOIN  inventaire.caracteristique caracteristique  left JOIN li.stockage stockage left JOIN li.catalogueFut catalogueFut WHERE li.etatFut = "+false+" and YEAR(inventaire.iinvDate) = 2017";
		this.QUeryName = query;
		return null;
	}
	
	public Response SituationFutPLeinMagasin() {
		String query = "SELECT li,year(li.inventaire.iinvDate) from  LigneInventaire li LEFT OUTER JOIN li.categorie categorie left JOIN li.inventaire inventaire left JOIN  inventaire.client client left JOIN  inventaire.caracteristique caracteristique  left JOIN li.stockage stockage left JOIN li.catalogueFut catalogueFut WHERE li.etatFut = "+false+" and YEAR(inventaire.iinvDate) = 2017";
		this.QUeryName = query;
		return null;
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
