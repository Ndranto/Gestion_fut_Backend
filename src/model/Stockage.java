package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Set;


/**
 * The persistent class for the stockage database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
@NamedQueries({
@NamedQuery(name="Stockage.findAll", query="SELECT S FROM Stockage S"),
@NamedQuery(name="Stockage.findAllId", query="SELECT S FROM Stockage S where S.stockId = :stockId"),
@NamedQuery(name="Stockage.findAllName", query="SELECT S FROM Stockage S where S.stockLieuStockage = :stockLieuStockage"),})
public class Stockage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="stock_id")
	private Integer stockId;

	@Column(name="stock_descr_stockage")
	private String stockDescrStockage;

	@Column(name="stock_lieu_stockage")
	private String stockLieuStockage;

	@Column(name="stock_solde")
	private Integer stockSolde;

	//bi-directional many-to-one association to Inventaire
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="stockage")
	private Set<Categoriser> categoriser;
	
	
	//bi-directional many-to-one association to Ville
	@ManyToOne
	@JoinColumn(name="ville_id_ville" ,referencedColumnName="ville_id_ville", insertable = false, updatable = false)
	private Ville ville;
	
	 
	 //bi-directional many-to-one association to Stocker
     @OneToMany(cascade = CascadeType.ALL,mappedBy="stockage")
	 private Set<Stockage_History> StockHistory;
	 

    @XmlTransient
	public Set<Stockage_History> getStockHistory() {
		return StockHistory;
	}

	public void setStockHistory(Set<Stockage_History> stockHistory) {
		StockHistory = stockHistory;
	}

	public Stockage() {
	}

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockDescrStockage() {
		return this.stockDescrStockage;
	}

	public void setStockDescrStockage(String stockDescrStockage) {
		this.stockDescrStockage = stockDescrStockage;
	}

	public String getStockLieuStockage() {
		return this.stockLieuStockage;
	}

	public void setStockLieuStockage(String stockLieuStockage) {
		this.stockLieuStockage = stockLieuStockage;
	}

	public Integer getStockSolde() {
		return this.stockSolde;
	}

	public void setStockSolde(Integer stockSolde) {
		this.stockSolde = stockSolde;
	}
    
	@XmlTransient
	public Set<Categoriser> getcategoriser() {
		return this.categoriser;
	}

	public void setcategoriser(Set<Categoriser> categoriser) {
		this.categoriser = categoriser;
	}

	public Categoriser addInventaire(Categoriser inventaire) {
		getcategoriser().add(inventaire);
		inventaire.setStockage(this);

		return inventaire;
	}

	public Categoriser removeInventaire(Categoriser inventaire) {
		getcategoriser().remove(inventaire);
		inventaire.setStockage(this);

		return inventaire;
	}

    
	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	

}