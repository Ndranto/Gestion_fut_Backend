package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.Set;


/**
 * The persistent class for the caracteristique database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
@NamedQueries({
@NamedQuery(name="Caracteristique.findAll", query="SELECT C FROM Caracteristique C"),
@NamedQuery(name="Caracteristique.findAllName", query="SELECT C FROM Caracteristique C WHERE C.caraNom = :caraNom "),})
public class Caracteristique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="cara_id")
	private Integer caraId;

	@Column(name="cara_nom")
	private String caraNom;
	
	//bi-directional many-to-one association to CatalogueFut
		@NotFound(action=NotFoundAction.IGNORE)
		@ManyToOne(optional =  false)
		@JoinColumn(name="type_id", referencedColumnName="type_id", insertable = false, updatable = false)
		private Type Type;
		
		
		
	//bi-directional many-to-one association to Bon
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="caracteristique")
	private Set<Bon> Bons;

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
	public Set<Bon> getBons() {
		return this.Bons;
	}

	public void setBons(Set<Bon> Bons) {
		this.Bons = Bons;
	}

public Bon addBon(Bon Bon) {
		getBons().add(Bon);
		Bon.setCaracteristique(this);

		return Bon;
	}

	public Bon removeBon(Bon Bon) {
		getBons().remove(Bon);
		Bon.setCaracteristique(null);

		return Bon;
	}

}