package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the bon database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
@Table
@NamedQuery(name="Bon.findAll", query="SELECT b FROM Bon b")
public class Bon implements Serializable {
	private static final long serialVersionUID = 1L;
    

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="bon_num")
	private Integer bonNum;
	
	@Column(name="bon_ref")
	private String RefBon;


	@Temporal(TemporalType.DATE)
	@Column(name="bon_date")
	private Date bonDate;

	@Column(name="bon_validation")
	private Boolean bonValidation;
	
	@Column(name="bon_qte_total")
	private Double qteTotal;


	//bi-directional many-to-one association to LigneInventaire
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="bon")
	private Set<Categoriser> categoriser ;
	
	/*//bi-directional many-to-one association to CatalogueFut
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne(optional =  false)
	@JoinColumn(name="ref_sortie", referencedColumnName="ref_sortie", insertable = false, updatable = false)
	private Sortie sortie;
	*/
	
	
	
	//bi-directional many-to-one association to CatalogueFut
	@ManyToOne(optional =  false)
	@JoinColumn(name="cli_id_client", referencedColumnName="cli_id_client", insertable = true, updatable = false)
	private Client client;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="cara_id",referencedColumnName="cara_id", insertable =true , updatable = false)
	private Caracteristique caracteristique;
	
	
	public Caracteristique getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}

	public Bon() {
		
	}

	public Integer getBonNum() {
		return this.bonNum;
	}

	public void setBonNum(Integer bonNum) {
		this.bonNum = bonNum;
	}

	public Date getBonDate() {
		return this.bonDate;
	}

	public void setBonDate(Date bonDate) {
		this.bonDate = bonDate;
	}

	public Boolean getBonValidation() {
		return this.bonValidation;
	}

	public void setBonValidation(Boolean bonValidation) {
		this.bonValidation = bonValidation;
	}





    public Double getQteTotal() {
		return qteTotal;
	}

	public void setQteTotal(Double qteTotal) {
		this.qteTotal = qteTotal;
	}

	public String getRefBon() {
		return RefBon;
	}

	public void setRefBon(String refBon) {
		RefBon = refBon;
	}



	@XmlTransient
	public Set<Categoriser> getCategoriser() {
		return categoriser;
	}

	public void setCategoriser(Set<Categoriser> categoriser) {
		this.categoriser = categoriser;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
/*
	public Sortie getSortie() {
		return sortie;
	}

	public void setSortie(Sortie sortie) {
		this.sortie = sortie;
	}
*/

	

}