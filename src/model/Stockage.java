package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stockage database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
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
	@OneToMany(mappedBy="stockage")
	private List<Inventaire> inventaires;

	//bi-directional many-to-one association to Ville
	@ManyToOne
	@JoinColumn(name="ville_id_ville")
	private Ville ville;
/*
	//bi-directional many-to-one association to Stocker
	@OneToMany(mappedBy="stockage")
	private List<Stocker> stockers;
*/
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

	public List<Inventaire> getInventaires() {
		return this.inventaires;
	}

	public void setInventaires(List<Inventaire> inventaires) {
		this.inventaires = inventaires;
	}

	public Inventaire addInventaire(Inventaire inventaire) {
		getInventaires().add(inventaire);
		inventaire.setStockage(this);

		return inventaire;
	}

	public Inventaire removeInventaire(Inventaire inventaire) {
		getInventaires().remove(inventaire);
		inventaire.setStockage(null);

		return inventaire;
	}

	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	/*
	public List<Stocker> getStockers() {
		return this.stockers;
	}

	public void setStockers(List<Stocker> stockers) {
		this.stockers = stockers;
	}

	public Stocker addStocker(Stocker stocker) {
		getStockers().add(stocker);
		stocker.setStockage(this);

		return stocker;
	}

	public Stocker removeStocker(Stocker stocker) {
		getStockers().remove(stocker);
		stocker.setStockage(null);

		return stocker;
	}
*/
}