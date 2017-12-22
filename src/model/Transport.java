package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the transport database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
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

	//bi-directional many-to-one association to Utiliser
	@OneToMany(mappedBy="transport")
	private List<Utiliser> utilisers;

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

	public List<Utiliser> getUtilisers() {
		return this.utilisers;
	}

	public void setUtilisers(List<Utiliser> utilisers) {
		this.utilisers = utilisers;
	}

	public Utiliser addUtiliser(Utiliser utiliser) {
		getUtilisers().add(utiliser);
		utiliser.setTransport(this);

		return utiliser;
	}

	public Utiliser removeUtiliser(Utiliser utiliser) {
		getUtilisers().remove(utiliser);
		utiliser.setTransport(null);

		return utiliser;
	}

}