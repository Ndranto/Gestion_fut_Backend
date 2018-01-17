package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;



/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
@NamedQueries({
@NamedQuery(name="Client.findAll", query="SELECT C FROM Client C"),
@NamedQuery(name="Client.findAllId", query="SELECT C  FROM Client C where C.cliIdClient = :cliIdClient"),
@NamedQuery(name="Client.findAllName", query="SELECT C FROM Client C where C.cliNom = :cliNom"),})
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cli_id_client")
	private Integer cliIdClient;

	@Column(name="cli_adresse")
	private String cliAdresse;

	@Column(name="cli_nom")
	private String cliNom;

	@Column(name="cli_solde_client")
	private Integer cliSoldeClient;

	//bi-directional many-to-one association to Ville
	@ManyToOne(optional =  false)
	@JoinColumn(name="ville_id_ville", referencedColumnName="ville_id_ville")
	private Ville ville;
/*
	//bi-directional many-to-one association to Inventaire
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="client")
	private Set<Inventaire> inventaires;
*/
	//bi-directional many-to-one association to Inventaire
		@OneToMany(cascade = CascadeType.ALL ,mappedBy="client")
		private Set<Bon> bon;
	public Client() {
	}

	public Integer getCliIdClient() {
		return this.cliIdClient;
	}

	public void setCliIdClient(Integer cliIdClient) {
		this.cliIdClient = cliIdClient;
	}

	public String getCliAdresse() {
		return this.cliAdresse;
	}

	public void setCliAdresse(String cliAdresse) {
		this.cliAdresse = cliAdresse;
	}

	public String getCliNom() {
		return this.cliNom;
	}

	public void setCliNom(String cliNom) {
		this.cliNom = cliNom;
	}

	public Integer getCliSoldeClient() {
		return this.cliSoldeClient;
	}

	public void setCliSoldeClient(Integer cliSoldeClient) {
		this.cliSoldeClient = cliSoldeClient;
	}
    
	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
    @XmlTransient
	public Set<Bon> getBon() {
		return bon;
	}

	public void setBon(Set<Bon> bon) {
		this.bon = bon;
	}
	
 /* @XmlTransient
	public Set<Inventaire> getInventaires() {
		return this.inventaires;
	}

	public void setInventaires(Set<Inventaire> inventaires) {
		this.inventaires = inventaires;
	}

	public Inventaire addInventaire(Inventaire inventaire) {
		getInventaires().add(inventaire);
		inventaire.setClient(this);

		return inventaire;
	}

	public Inventaire removeInventaire(Inventaire inventaire) {
		getInventaires().remove(inventaire);
		inventaire.setClient(null);

		return inventaire;
	}
	*/

}