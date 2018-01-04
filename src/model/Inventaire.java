package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the inventaire database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
@NamedQueries({
@NamedQuery(name="Inventaire.findAll", query="SELECT i FROM Inventaire i"),
@NamedQuery(name="Inventaire.findAllId", query="SELECT i FROM Inventaire i where i.invId = :invId"),
@NamedQuery(name="Inventaire.findAllDate", query="SELECT i FROM Inventaire i where i.iinvDate= :iinvDate")})
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

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="inventaire")
	private Set<Utiliser> utilise;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="inventaire")
	private Set<LigneInventaire> LigneInventaire;
	

	//bi-directional many-to-one association to Stockage
	@ManyToOne(optional =false)
	@JoinColumn(name="cli_id_client",referencedColumnName="cli_id_client",insertable = false, updatable = false)
	private Client client;
	
	//bi-directional many-to-one association to Stockage
	@ManyToOne(optional =false)
	@JoinColumn(name="stock_id",referencedColumnName="stock_id",insertable = false, updatable = false)
	private Stockage stockage;
	
	//bi-directional many-to-one association to Stockage
	@ManyToOne(optional =false)
	@JoinColumn(name="cara_id",referencedColumnName="cara_id",insertable = false, updatable = false)
	private Caracteristique caracteristique;
	
	@XmlTransient
	public Set<LigneInventaire> getLigneInventaire() {
		return LigneInventaire;
	}

	public void setLigneInventaire(Set<LigneInventaire> ligneInventaire) {
		LigneInventaire = ligneInventaire;
	}

	@XmlTransient
	public Set<Utiliser> getUtilise() {
		return utilise;
	}

	public void setUtilise(Set<Utiliser> utilise) {
		this.utilise = utilise;
	}
	
	
	public Client getClient() {
		return client;
	}
    
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public Stockage getStockage() {
		return stockage;
	}

	public void setStockage(Stockage stockage) {
		this.stockage = stockage;
	}
	
	
	public Caracteristique getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}

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

}