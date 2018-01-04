package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the utiliser database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Utiliser.findAll", query="SELECT u FROM Utiliser u"),
@NamedQuery(name="Utiliser.findTranport", query="SELECT u FROM Utiliser u where u.id.transId = :transId"),
@NamedQuery(name="Utiliser.findInv", query="SELECT u FROM Utiliser u where u.id.invId = :invId"),})
public class Utiliser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected UtiliserPK id;

	@Column(name="nombre_camion_utilise")
	private Integer nombreCamionUtilise;
	
	//bi-directional many-to-one association to Ville
	@JoinColumn(name="trans_id", referencedColumnName="trans_id", insertable = false, updatable = false)
	@ManyToOne(optional =  false)
	private Transport transport;
	
	//bi-directional many-to-one association to Ville
	@JoinColumn(name="inv_id", referencedColumnName="inv_id", insertable = false, updatable = false)
	@ManyToOne(optional =  false)
    private Inventaire inventaire;

	public Utiliser() {
	}

	public UtiliserPK getId() {
		return this.id;
	}
    
	public void setId(UtiliserPK id) {
		this.id = id;
	}

	public Integer getNombreCamionUtilise() {
		return this.nombreCamionUtilise;
	}

	public void setNombreCamionUtilise(Integer nombreCamionUtilise) {
		this.nombreCamionUtilise = nombreCamionUtilise;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}




}