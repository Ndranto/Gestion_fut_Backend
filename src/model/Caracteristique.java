package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Set;


/**
 * The persistent class for the caracteristique database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
@NamedQueries({
@NamedQuery(name="Caracteristique.findAll", query="SELECT C FROM Caracteristique C"),})
public class Caracteristique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cara_id")
	private Integer caraId;

	@Column(name="cara_nom")
	private String caraNom;

	//bi-directional many-to-one association to Inventaire
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="caracteristique")
	private Set<Inventaire> inventaires;

	public Caracteristique() {
	}

	public Integer getCaraId() {
		return this.caraId;
	}

	public void setCaraId(Integer caraId) {
		this.caraId = caraId;
	}

	public String getCaraNom() {
		return this.caraNom;
	}

	public void setCaraNom(String caraNom) {
		this.caraNom = caraNom;
	}
	
    @XmlTransient
	public Set<Inventaire> getInventaires() {
		return this.inventaires;
	}

	public void setInventaires(Set<Inventaire> inventaires) {
		this.inventaires = inventaires;
	}

public Inventaire addInventaire(Inventaire inventaire) {
		getInventaires().add(inventaire);
		inventaire.setCaracteristique(this);

		return inventaire;
	}

	public Inventaire removeInventaire(Inventaire inventaire) {
		getInventaires().remove(inventaire);
		inventaire.setCaracteristique(null);

		return inventaire;
	}

}