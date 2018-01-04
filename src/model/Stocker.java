package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the stocker database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
@NamedQueries({
@NamedQuery(name="Stocker.findAll", query="SELECT S FROM Stocker S"),
@NamedQuery(name="Stocker.findAllId", query="SELECT S FROM Stocker S where S.id.stockId = :stockId"),
@NamedQuery(name="Stocker.findAllName", query="SELECT S FROM Stocker S where S.nbre_Fut_Stocker = :nbre_Fut_Stocker"),})

public class Stocker implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StockerPK id;

	@Column(name="\"Cat_Id\"")
	private Integer cat_Id;

	@Column(name="\"Etat_Fut_Stocker\"")
	private Boolean etat_Fut_Stocker;

	@Column(name="\"Nbre_Fut_Stocker\"")
	private double nbre_Fut_Stocker;

	//bi-directional many-to-one association to CatalogueFut
	@ManyToOne(optional =false)
	@JoinColumn(name="fut_id", referencedColumnName="fut_id",insertable = false, updatable = false)
	private CatalogueFut catalogueFut;

	//bi-directional many-to-one association to Stockage
	@ManyToOne(optional =false)
	@JoinColumn(name="stock_id",referencedColumnName="stock_id",insertable = false, updatable = false)
	private Stockage stockage;

	public Stocker() {
	}

	public StockerPK getId() {
		return this.id;
	}

	public void setId(StockerPK id) {
		this.id = id;
	}

	public Integer getCat_Id() {
		return this.cat_Id;
	}

	public void setCat_Id(Integer cat_Id) {
		this.cat_Id = cat_Id;
	}

	public Boolean getEtat_Fut_Stocker() {
		return this.etat_Fut_Stocker;
	}

	public void setEtat_Fut_Stocker(Boolean etat_Fut_Stocker) {
		this.etat_Fut_Stocker = etat_Fut_Stocker;
	}

	public double getNbre_Fut_Stocker() {
		return this.nbre_Fut_Stocker;
	}

	public void setNbre_Fut_Stocker(double nbre_Fut_Stocker) {
		this.nbre_Fut_Stocker = nbre_Fut_Stocker;
	}

	public CatalogueFut getCatalogueFut() {
		return this.catalogueFut;
	}

	public void setCatalogueFut(CatalogueFut catalogueFut) {
		this.catalogueFut = catalogueFut;
	}

	public Stockage getStockage() {
		return this.stockage;
	}

	public void setStockage(Stockage stockage) {
		this.stockage = stockage;
	}

}