package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the inventaire database table.
 * 
 */
@Entity
@Table(name="inventaire")
@NamedQueries({
@NamedQuery(name="Inventaire.findAll", query="SELECT i FROM Inventaire i"),})
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
/*
	@Column(name="inv_type")
	private String invType;

	
	@Column(name="inv_validation_inventory")
	private Boolean invValidationInventory;
*/
	//bi-directional many-to-one association to Caracteristique
	@ManyToOne(optional = false)
	@JoinColumn(name="cara_id",referencedColumnName="cara_id", insertable =false , updatable = false)
	private Caracteristique caracteristique;

	/*/bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="cli_id_client")
	private Client client;
*/

	//bi-directional many-to-one association to LigneInventaire
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="Inventaires")
	private Set<Categoriser> categoriser ;
/*
	//bi-directional many-to-one association to Utiliser
	@OneToMany(mappedBy="inventaire")
	private Set<Utiliser> utilisers;
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
/*	public String getInvType() {
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
*/
	public Caracteristique getCaracteristique() {
		return this.caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}
/*
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
*/
    @XmlTransient
	public Set<Categoriser> getCategoriser() {
		return categoriser;
	}

	public void setCategoriser(Set<Categoriser> categoriser) {
		this.categoriser = categoriser;
	}

 
	
/*
	@XmlTransient
	public Set<Utiliser> getUtilisers() {
		return this.utilisers;
	}
	

	public void setUtilisers(Set<Utiliser> utilisers) {
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