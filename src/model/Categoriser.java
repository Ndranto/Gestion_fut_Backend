package model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.math.BigDecimal;



/**
 * The persistent class for the categoriser database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)

@NamedQueries({
@NamedQuery(name="Categoriser.findAll", query="SELECT c FROM Categoriser c"),
@NamedQuery(name="Categoriser.findAllId", query="SELECT c FROM Categoriser c where c.idCategoriser = :catId"),
//@NamedQuery(name="Categoriser.findAllName", query="SELECT c FROM Categoriser c where c.catFut = :catFut"),
})
public class Categoriser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_categoriser")
	private Integer idCategoriser;
	

	@Column(name="\"Qte_fut\"")
	private BigDecimal qtefut;
	
	@JoinColumn(name="cat_id", referencedColumnName="cat_id", insertable =false , updatable = false)
	@ManyToOne (optional = false)
	private Categorie categorie;
	//bi-directional many-to-one association to CatalogueFut
	@ManyToOne(optional =  false)
	 @NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="bon_num", referencedColumnName="bon_num", insertable = false, updatable = false)
	private Bon bon;
		
	@JoinColumn(name="trans_id", referencedColumnName="trans_id", insertable =false , updatable = false)
	@ManyToOne (optional = false)
	private Transport transport;
	
	@JoinColumn(name="fut_id", referencedColumnName="fut_id", insertable =false , updatable = false)
	@ManyToOne (optional = false)
	private CatalogueFut catalogueFut;
	
    //bi-directional many-to-one association to CatalogueFut
	@ManyToOne(optional =  false)
	@JoinColumn(name="stock_id", referencedColumnName="stock_id", insertable = false, updatable = false)
	private Stockage stockage;
	
	//bi-directional many-to-one association to CatalogueFut
	@ManyToOne(optional =  false)
	@JoinColumn(name="etat_id", referencedColumnName="etat_id", insertable = false, updatable = false)
	private Etat etat;
	
	//bi-directional many-to-one association to CatalogueFut
	@ManyToOne(optional =  false)
	@JoinColumn(name="inv_id", referencedColumnName="inv_id", insertable = false, updatable = false)
	private Inventaire Inventaires;

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Categoriser() {
	}

	public Integer getIdCategoriser() {
		return this.idCategoriser;
	}

	public void setIdCategoriser(Integer idCategoriser) {
		this.idCategoriser = idCategoriser;
	}



	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public CatalogueFut getCatalogueFut() {
		return catalogueFut;
	}

	public void setCatalogueFut(CatalogueFut catalogueFut) {
		this.catalogueFut = catalogueFut;
	}

	public BigDecimal getQte_fut() {
		return this.qtefut;
	}

	public void setQte_fut(BigDecimal qte_fut) {
		this.qtefut = qte_fut;
	}
	
	
	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}


	public Bon getBon() {
		return bon;
	}

	public void setBon(Bon bon) {
		this.bon = bon;
	}

	public Inventaire getInventaires() {
		return Inventaires;
	}

	public void setInventaires(Inventaire inventaires) {
		Inventaires = inventaires;
	}

	public void setStockage(Stockage stockage) {
		this.stockage = stockage;
	}

	public Stockage getStockage() {
		return this.stockage;
	}
	
	
}