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

@NamedQueries({
@NamedQuery(name="Type.findAll", query="SELECT T FROM Type T"),
@NamedQuery(name="Type.findAllId", query="SELECT T  FROM Type T where T.typeId = :typeId"),
@NamedQuery(name="Type.findAllName", query="SELECT T FROM Type T where T.TypeName = :TypeName"),})
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
		private Set<Caracteristique> Caracteristique;
		
    @XmlTransient
	public Set<Caracteristique> getCaracteristique() {
			return Caracteristique;
		}

		public void setCaracteristique(Set<Caracteristique> Caracteristique) {
			this.Caracteristique = Caracteristique;
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