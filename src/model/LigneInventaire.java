package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ligne_inventaire database table.
 * 
 */
@Entity
@Table(name="ligne_inventaire")
@Access(value=AccessType.FIELD)
public class LigneInventaire implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@EmbeddedId
	private LigneInventairePK id;

	@Column(name="\"cat_Id\"")
	private Integer cat_Id;

	@Column(name="\"Etat_Fut\"")
	private Boolean etat_Fut;

	@Column(name="\"Qte_Fut_Inv\"")
	private double qte_Fut_Inv;

	//bi-directional many-to-one association to CatalogueFut
	@ManyToOne
	@JoinColumn(name="fut_id", referencedColumnName="fut_id")
	private CatalogueFut catalogueFut;

	//bi-directional many-to-one association to Inventaire
	
	@ManyToOne
	@JoinColumn(name="inv_id" , referencedColumnName="inv_id")
	private Inventaire inventaire;

	public LigneInventaire() {
	}

	public LigneInventaire(LigneInventairePK ligneinventairePk) {
		this.id = ligneinventairePk;
	}

	public LigneInventairePK getId() {
		return this.id;
	}

	public void setId(LigneInventairePK id) {
		this.id = id;
	}

	public Integer getCat_Id() {
		return this.cat_Id;
	}

	public void setCat_Id(Integer cat_Id) {
		this.cat_Id = cat_Id;
	}

	public Boolean getEtat_Fut() {
		return this.etat_Fut;
	}

	public void setEtat_Fut(Boolean etat_Fut) {
		this.etat_Fut = etat_Fut;
	}

	public double getQte_Fut_Inv() {
		return this.qte_Fut_Inv;
	}

	public void setQte_Fut_Inv(double qte_Fut_Inv) {
		this.qte_Fut_Inv = qte_Fut_Inv;
	}

	public CatalogueFut getCatalogueFut() {
		return this.catalogueFut;
	}

	public void setCatalogueFut(CatalogueFut catalogueFut) {
		this.catalogueFut = catalogueFut;
	}

	public Inventaire getInventaire() {
		return this.inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

}