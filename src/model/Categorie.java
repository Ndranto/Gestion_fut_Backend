package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
@NamedQueries({
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c"),
@NamedQuery(name="Categorie.findAllId", query="SELECT c FROM Categorie c where c.catId = :catId"),
@NamedQuery(name="Categorie.findAllName", query="SELECT c FROM Categorie c where c.catFut = :catFut"),})

public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cat_id")
	private Integer catId;
	//bi-directional many-to-one association to LigneInventaire
	@OneToMany(cascade = CascadeType.ALL, mappedBy="categorie" )
	private Set<LigneInventaire> ligneInventaires;



	@Column(name="cat_fut")
	private String catFut;

	public Categorie() {
	}

	@XmlTransient
	public Set<LigneInventaire> getLigneInventaires() {
		return ligneInventaires;
	}

	public void setLigneInventaires(Set<LigneInventaire> ligneInventaires) {
		this.ligneInventaires = ligneInventaires;
	}

	public Integer getCatId() {
		return this.catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatFut() {
		return this.catFut;
	}

	public void setCatFut(String catFut) {
		this.catFut = catFut;
	}

}