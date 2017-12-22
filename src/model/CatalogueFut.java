package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catalogue_fut database table.
 * 
 */
@Entity
@Table(name="catalogue_fut")
@Access(value=AccessType.FIELD)
@NamedQueries({
@NamedQuery(name="CatalogueFut.findAll", query="SELECT c FROM CatalogueFut c"),
@NamedQuery(name="CatalogueFut.findAllId", query="SELECT c FROM CatalogueFut c where c.futId = :futId"),
@NamedQuery(name="CatalogueFut.findAllName", query="SELECT c FROM CatalogueFut c where c.futNomCatalogueFut = :NameFut"),})
public class CatalogueFut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fut_id")
	private Integer futId;

	@Column(name="fut_descr_catalogue_fut")
	private String futDescrCatalogueFut;

	@Column(name="fut_nom_catalogue_fut")
	private String futNomCatalogueFut;

	//bi-directional many-to-one association to LigneInventaire
	@OneToMany(mappedBy="catalogueFut")
	private List<LigneInventaire> ligneInventaires;

	//bi-directional many-to-one association to Stocker
	@OneToMany(mappedBy="catalogueFut")
	private List<Stocker> stockers;

	public CatalogueFut() {
	}

	public Integer getFutId() {
		return this.futId;
	}

	public void setFutId(Integer futId) {
		this.futId = futId;
	}

	public String getFutDescrCatalogueFut() {
		return this.futDescrCatalogueFut;
	}

	public void setFutDescrCatalogueFut(String futDescrCatalogueFut) {
		this.futDescrCatalogueFut = futDescrCatalogueFut;
	}

	public String getFutNomCatalogueFut() {
		return this.futNomCatalogueFut;
	}

	public void setFutNomCatalogueFut(String futNomCatalogueFut) {
		this.futNomCatalogueFut = futNomCatalogueFut;
	}

	public List<LigneInventaire> getLigneInventaires() {
		return this.ligneInventaires;
	}

	public void setLigneInventaires(List<LigneInventaire> ligneInventaires) {
		this.ligneInventaires = ligneInventaires;
	}

	public LigneInventaire addLigneInventaire(LigneInventaire ligneInventaire) {
		getLigneInventaires().add(ligneInventaire);
		ligneInventaire.setCatalogueFut(this);

		return ligneInventaire;
	}

	public LigneInventaire removeLigneInventaire(LigneInventaire ligneInventaire) {
		getLigneInventaires().remove(ligneInventaire);
		ligneInventaire.setCatalogueFut(null);

		return ligneInventaire;
	}

	public List<Stocker> getStockers() {
		return this.stockers;
	}

	public void setStockers(List<Stocker> stockers) {
		this.stockers = stockers;
	}

	public Stocker addStocker(Stocker stocker) {
		getStockers().add(stocker);
		stocker.setCatalogueFut(this);

		return stocker;
	}

	public Stocker removeStocker(Stocker stocker) {
		getStockers().remove(stocker);
		stocker.setCatalogueFut(null);

		return stocker;
	}

}