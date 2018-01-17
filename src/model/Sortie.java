package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


/**
 * The persistent class for the sortie database table.
 * 
 */
@Entity
@NamedQuery(name="Sortie.findAll", query="SELECT s FROM Sortie s")
public class Sortie  implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@NotFound(action=NotFoundAction.IGNORE)
	@Column(name="ref_sortie")
	private String refSortie;
    /*
	//bi-directional many-to-one association to LigneInventaire
	@OneToMany(cascade = CascadeType.ALL, mappedBy="sortie" )
	private Set<Bon> bon;
	*/
/*    @XmlTransient
	public Set<Bon> getBon() {
		return bon;
	}


	public void setBon(Set<Bon> bon) {
		this.bon = bon;
	}

*/
	public Sortie() {
	}
	

	public String getRefSortie() {
		return this.refSortie;
	}

	public void setRefSortie(String refSortie) {
		this.refSortie = refSortie;
	}

}