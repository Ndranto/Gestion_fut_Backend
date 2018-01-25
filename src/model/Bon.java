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
	@GeneratedValue(strategy=GenerationType.TABLE)
	@NotFound(action=NotFoundAction.IGNORE)
	@Column(name="bon_num")
	private Integer bonNum;
	
	@Column(name="bon_ref")
	private String RefBon;


	@Temporal(TemporalType.DATE)
	@Column(name="bon_date")
	private Date bonDate;

	@Column(name="bon_validation")
	private Boolean bonValidation;

	@Column(name="cli_id_client")
	private Integer cliIdClient;


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
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne(optional =  false)
	@JoinColumn(name="type_id", referencedColumnName="type_id", insertable = false, updatable = false)
	private Type Type;
	
	//bi-directional many-to-one association to CatalogueFut
	@ManyToOne(optional =  false)
	@JoinColumn(name="cli_id_client", referencedColumnName="cli_id_client", insertable = false, updatable = false)
	private Client client;
	
	
	
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

	public Integer getCliIdClient() {
		return this.cliIdClient;
	}

	public void setCliIdClient(Integer cliIdClient) {
		this.cliIdClient = cliIdClient;
	}




    public String getRefBon() {
		return RefBon;
	}

	public void setRefBon(String refBon) {
		RefBon = refBon;
	}

	public Type getType() {
		return Type;
	}

	public void setType(Type type) {
		Type = type;
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