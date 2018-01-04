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
@NamedQueries({
@NamedQuery(name="LigneInvAll", query="SELECT LI FROM LigneInventaire  LI"),
@NamedQuery(name="LigneInvId", query="SELECT LI FROM LigneInventaire LI where LI.id = :id"),
@NamedQuery(name="LigneInvEtatFut", query="SELECT LI FROM LigneInventaire LI where LI.etat_Fut = :etat_Fut"),
@NamedQuery(name="LigneInvQteFUt", query="SELECT LI FROM LigneInventaire LI where LI.qte_Fut_Inv = :qte_Fut_Inv"),})
public class LigneInventaire implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@EmbeddedId
	private LigneInventairePK id;
	@Column(name="\"Etat_Fut\"")
	private Boolean etat_Fut;

	@Column(name="\"Qte_Fut_Inv\"")
	private double qte_Fut_Inv;

	//bi-directional many-to-one association to CatalogueFut
	@JoinColumn(name="fut_id", referencedColumnName="fut_id", insertable =false , updatable = false)
	@ManyToOne(optional = false)
	private CatalogueFut catalogueFut;
	
	//bi-directional many-to-one association to CatalogueFut
	@JoinColumn(name="cat_id", referencedColumnName="cat_id", insertable =false , updatable = false)
	@ManyToOne (optional = false)
	private Categorie categorie;

	//bi-directional many-to-one association to Inventaire
	@JoinColumn(name="inv_id" , referencedColumnName="inv_id" ,insertable =false , updatable = false)
	@ManyToOne (optional = false)
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}