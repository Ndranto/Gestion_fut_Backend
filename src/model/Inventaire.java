package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the inventaire database table.
 * 
 */
@Entity
@Table(name="inventaire")
@Access(value=AccessType.FIELD)
public class Inventaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="inv_id")
	private Integer invId;

	@Temporal(TemporalType.DATE)
	@Column(name="iinv_date")
	private Date iinvDate;

	@Column(name="inv_observation")
	private String invObservation;

	@Column(name="inv_qte")
	private Integer invQte;

	@Column(name="inv_type")
	private String invType;

	@Column(name="inv_validation_inventory")
	private Boolean invValidationInventory;

	//bi-directional many-to-one association to Caracteristique
	@ManyToOne
	@JoinColumn(name="cara_id")
	private Caracteristique caracteristique;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="cli_id_client")
	private Client client;

	//bi-directional many-to-one association to Stockage
	@ManyToOne
	@JoinColumn(name="stock_id")
	private Stockage stockage;
	//bi-directional many-to-one association to LigneInventaire
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="inventaire")
	private List<LigneInventaire> ligneInventaires;
/*
	//bi-directional many-to-one association to Utiliser
	@OneToMany(mappedBy="inventaire")
	private List<Utiliser> utilisers;
*/
	public Inventaire() {
	}

	public Integer getInvId() {
		return this.invId;
	}

	public void setInvId(Integer invId) {
		this.invId = invId;
	}

	public Date getIinvDate() {
		return this.iinvDate;
	}

	public void setIinvDate(Date iinvDate) {
		this.iinvDate = iinvDate;
	}

	public String getInvObservation() {
		return this.invObservation;
	}

	public void setInvObservation(String invObservation) {
		this.invObservation = invObservation;
	}

	public Integer getInvQte() {
		return this.invQte;
	}

	public void setInvQte(Integer invQte) {
		this.invQte = invQte;
	}

	public String getInvType() {
		return this.invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

	public Boolean getInvValidationInventory() {
		return this.invValidationInventory;
	}

	public void setInvValidationInventory(Boolean invValidationInventory) {
		this.invValidationInventory = invValidationInventory;
	}

	public Caracteristique getCaracteristique() {
		return this.caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Stockage getStockage() {
		return this.stockage;
	}

	public void setStockage(Stockage stockage) {
		this.stockage = stockage;
	}

	public List<LigneInventaire> getLigneInventaires() {
		return this.ligneInventaires;
	}

	public void setLigneInventaires(List<LigneInventaire> ligneInventaires) {
		this.ligneInventaires = ligneInventaires;
	}

	public LigneInventaire addLigneInventaire(LigneInventaire ligneInventaire) {
		getLigneInventaires().add(ligneInventaire);
		ligneInventaire.setInventaire(this);

		return ligneInventaire;
	}

	public LigneInventaire removeLigneInventaire(LigneInventaire ligneInventaire) {
		getLigneInventaires().remove(ligneInventaire);
		ligneInventaire.setInventaire(null);

		return ligneInventaire;
	}
/*
	public List<Utiliser> getUtilisers() {
		return this.utilisers;
	}

	public void setUtilisers(List<Utiliser> utilisers) {
		this.utilisers = utilisers;
	}

	public Utiliser addUtiliser(Utiliser utiliser) {
		getUtilisers().add(utiliser);
		utiliser.setInventaire(this);

		return utiliser;
	}

	public Utiliser removeUtiliser(Utiliser utiliser) {
		getUtilisers().remove(utiliser);
		utiliser.setInventaire(null);

		return utiliser;
	}
	*/

}