package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the etat database table.
 * 
 */
@Entity
@NamedQuery(name="Etat.findAll", query="SELECT e FROM Etat e")
public class Etat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="etat_id")
	private Integer etatId;

	@Column(name="\"etat_Name\"")
	private Boolean etat_Name;
    
	//bi-directional many-to-one association to LigneInventaire
	@OneToMany(cascade = CascadeType.ALL, mappedBy="etat" )
	private Set<Categoriser> Categoriser;
	
	public Etat() {
	}

	public Integer getEtatId() {
		return this.etatId;
	}

	public void setEtatId(Integer etatId) {
		this.etatId = etatId;
	}

	public Boolean getEtat_Name() {
		return this.etat_Name;
	}

	public void setEtat_Name(Boolean etat_Name) {
		this.etat_Name = etat_Name;
	}
    @XmlTransient
	public Set<Categoriser> getCategoriser() {
		return Categoriser;
	}

	public void setCategoriser(Set<Categoriser> categoriser) {
		Categoriser = categoriser;
	}
    
}