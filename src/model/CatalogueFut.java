package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the catalogue_fut database table.
 * 
 */
@Entity
@Table(name="catalogue_fut")
@NamedQuery(name="CatalogueFut.findAll", query="SELECT c FROM CatalogueFut c")
public class CatalogueFut implements Serializable {
private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fut_id")
	private Integer futId;

	@Column(name="fut_descr_catalogue_fut")
	private String futDescrCatalogueFut;

	@Column(name="fut_nom_catalogue_fut")
	private String futNomCatalogueFut;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Categorie categorie;

	

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

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	public CatalogueFut(Integer futId, String futDescrCatalogueFut,
			String futNomCatalogueFut, Categorie categorie) {
		super();
		this.futId = futId;
		this.futDescrCatalogueFut = futDescrCatalogueFut;
		this.futNomCatalogueFut = futNomCatalogueFut;
		this.categorie = categorie;
	}
	public CatalogueFut() {
			
		}
}