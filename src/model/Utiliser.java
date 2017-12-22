package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the utiliser database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
public class Utiliser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UtiliserPK id;

	@Column(name="nombre_camion_utilise")
	private Integer nombreCamionUtilise;

	//bi-directional many-to-one association to Inventaire
	@ManyToOne
	@JoinColumn(name="inv_id")
	private Inventaire inventaire;

	//bi-directional many-to-one association to Transport
	@ManyToOne
	@JoinColumn(name="trans_id")
	private Transport transport;

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

	public Inventaire getInventaire() {
		return this.inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public Transport getTransport() {
		return this.transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

}