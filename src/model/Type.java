package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


/**
 * The persistent class for the entrer database table.
 * 
 */
@Entity
@Table
@NamedQuery(name="Type.findAll", query="SELECT e FROM Type e")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@NotFound(action=NotFoundAction.IGNORE)
	@Column(name="type_id")
	private Integer typeId;
	//bi-directional many-to-one association to LigneInventaire
	
	@Column(name="type_name")
	private String TypeName;
	
		@OneToMany(cascade = CascadeType.ALL, mappedBy="Type" )
		private Set<Bon> bon;
		
    @XmlTransient
	public Set<Bon> getBon() {
			return bon;
		}

		public void setBon(Set<Bon> bon) {
			this.bon = bon;
		}

	public Type() {
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return TypeName;
	}

	public void String(String typeName) {
		TypeName = typeName;
	}
	



}