package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cat_id")
	private Integer catId;

	@Column(name="cat_fut")
	private String catFut;

	//bi-directional many-to-one association to CatalogueFut
	@OneToMany(mappedBy="categorie")
	private List<CatalogueFut> catalogueFuts;

	public Categorie() {
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

	public List<CatalogueFut> getCatalogueFuts() {
		return this.catalogueFuts;
	}

	public void setCatalogueFuts(List<CatalogueFut> catalogueFuts) {
		this.catalogueFuts = catalogueFuts;
	}

	public CatalogueFut addCatalogueFut(CatalogueFut catalogueFut) {
		getCatalogueFuts().add(catalogueFut);
		catalogueFut.setCategorie(this);

		return catalogueFut;
	}

	public CatalogueFut removeCatalogueFut(CatalogueFut catalogueFut) {
		getCatalogueFuts().remove(catalogueFut);
		catalogueFut.setCategorie(null);

		return catalogueFut;
	}

}