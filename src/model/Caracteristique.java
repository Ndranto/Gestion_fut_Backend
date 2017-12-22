package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the caracteristique database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
public class Caracteristique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cara_id")
	private Integer caraId;

	@Column(name="cara_nom")
	private String caraNom;

	//bi-directional many-to-one association to Inventaire
	@OneToMany(mappedBy="caracteristique")
	private List<Inventaire> inventaires;

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

	public List<Inventaire> getInventaires() {
		return this.inventaires;
	}

	public void setInventaires(List<Inventaire> inventaires) {
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