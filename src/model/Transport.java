package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Set;


/**
 * The persistent class for the transport database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
@NamedQueries({
@NamedQuery(name="TransportAll", query="SELECT T FROM Transport  T"),
@NamedQuery(name="TransportAllId", query="SELECT T FROM Transport T where T.transId = :transId"),
@NamedQuery(name="TransportCapacite", query="SELECT T FROM Transport T where T.transCapacite = :transCapacite"),
@NamedQuery(name="TransportMatricule", query="SELECT T FROM Transport T where T.transIm = :transIm"),})
public class Transport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="trans_id")
	private Integer transId;

	@Column(name="trans_capacite")
	private String transCapacite;

	@Column(name="trans_im")
	private String transIm;
	
	//bi-directional many-to-one association to Utilisers
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="transport")
	private Set<Categoriser> Categoriser;

	public Transport() {
	}

	public Integer getTransId() {
		return this.transId;
	}

	public void setTransId(Integer transId) {
		this.transId = transId;
	}

	public String getTransCapacite() {
		return this.transCapacite;
	}

	public void setTransCapacite(String transCapacite) {
		this.transCapacite = transCapacite;
	}

	public String getTransIm() {
		return this.transIm;
	}



	public void setTransIm(String transIm) {
		this.transIm = transIm;
	}

	@XmlTransient
	public Set<Categoriser> getCategoriser() {
		return this.Categoriser;
	}

	public void setCategoriser(Set<Categoriser> Categoriser) {
		this.Categoriser = Categoriser;
	}


}