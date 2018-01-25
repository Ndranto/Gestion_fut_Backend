package model;

import java.io.Serializable;
import java.util.Set;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;




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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="fut_id")
	private Integer futId;

	@Column(name="fut_descr_catalogue_fut")
	private String futDescrCatalogueFut;

	@Column(name="fut_nom_catalogue_fut")
	private String futNomCatalogueFut;
	
	//bi-directional many-to-one association to LigneInventaire
	@OneToMany( mappedBy="catalogueFut",  cascade = CascadeType.ALL)
	private Set<Categoriser> Categoriser;
/*
	//bi-directional many-to-one association to Stocker
	@OneToMany(cascade = CascadeType.ALL,mappedBy="catalogueFut")
	private Set<Stocker> stockers;
    */
	public CatalogueFut() {
	}
    
	public CatalogueFut(Integer futId, String futDescrCatalogueFut,
		String futNomCatalogueFut) {
	super();
	this.futId = futId;
	this.futDescrCatalogueFut = futDescrCatalogueFut;
	this.futNomCatalogueFut = futNomCatalogueFut;
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
   
	@XmlTransient
	public Set<Categoriser> getCategoriser() {
		return Categoriser;
	}

	public void setCategoriser(Set<Categoriser> categoriser) {
		Categoriser = categoriser;
	}
	  
	
	/*	public Categoriser addCategoriser(Categoriser Categoriser) {
			getCategoriser().add(Categoriser);
			Categoriser.setCatalogueFut(this);

			return Categoriser;
		}
	public Categoriser removeCategoriser(Categoriser Categoriser) {
		getCategoriser().remove(Categoriser);
		Categoriser.setCatalogueFut(null);

		return Categoriser;
	}

	@XmlTransient
	public Set<Stocker> getStockers() {
		return this.stockers;
	}

	public void setStockers(Set<Stocker> stockers) {
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
*/
}