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
@NamedQuery(name="LigneInventaire", query="SELECT li FROM LigneInventaire li"),
@NamedQuery(name="LigneInv.findAllId", query="SELECT  li FROM LigneInventaire  li where  li.id.invId = :invId"),
@NamedQuery(name="LigneIn.findAllName", query="SELECT  li FROM LigneInventaire  li where  li.id.idCategoriser = :idCategoriser"),})
public class LigneInventaire implements Serializable {
	private static final long serialVersionUID = 1L;
  
	@EmbeddedId
	private LigneInventairePK id;


	@Column(name="etat_Fut")
	private Boolean etat_Fut;

	@Column(name="nbre_fut")
	private double nbreFut;


	//bi-directional many-to-one association to Inventaire
	/*
	@ManyToOne(optional =  false)
	@JoinColumn(name="inv_id" , referencedColumnName="inv_id", insertable = false, updatable = false)
	private Inventaire inventaire;


	@ManyToOne(optional =  false)
	@JoinColumn(name="id_categoriser" , referencedColumnName="id_categoriser", insertable = false, updatable = false)
	private Categoriser categoriser;
	*/

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



	public double getNbreFUt() {
		return nbreFut;
	}

	public void setNbreFUt(double nbreFUt) {
		this.nbreFut = nbreFUt;
	}
/*
	public Categoriser getCategoriser() {
		return categoriser;
	}

	public void setCategoriser(Categoriser categoriser) {
		this.categoriser = categoriser;
	}


	public Inventaire getInventaire() {
		return this.inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
*/
}