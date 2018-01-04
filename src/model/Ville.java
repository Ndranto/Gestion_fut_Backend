package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the ville database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)

@NamedQueries({
@NamedQuery(name="Ville.findAll", query="SELECT v FROM Ville v"),
@NamedQuery(name="Ville.findAllId", query="SELECT v  FROM Ville v where v.villeIdVille = :villeIdVille"),
@NamedQuery(name="Ville.findAllName", query="SELECT v FROM Ville v where v.villeNameVille = :villeNameVille"),})
public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ville_id_ville")
	private Integer villeIdVille;

	@Column(name="ville_name_ville")
	private String villeNameVille;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ville")
	private Set<Client> clients;

	//bi-directional many-to-one association to Stockage
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="" )
	private Set<Stockage> stockages;
	public Ville() {
	}

	public Integer getVilleIdVille() {
		return this.villeIdVille;
	}

	public void setVilleIdVille(Integer villeIdVille) {
		this.villeIdVille = villeIdVille;
	}

	public String getVilleNameVille() {
		return this.villeNameVille;
	}

	public void setVilleNameVille(String villeNameVille) {
		this.villeNameVille = villeNameVille;
	}

	@XmlTransient
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setVille(this);

		return client;
	}
	

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setVille(null);

		return client;
	}
    
	@XmlTransient
	public Set<Stockage> getStockages() {
		return this.stockages;
	}

	public void setStockages(Set<Stockage> stockages) {
		this.stockages = stockages;
	}


	public Stockage addStockage(Stockage stockage) {
		getStockages().add(stockage);
		stockage.setVille(this);

		return stockage;
	}

	public Stockage removeStockage(Stockage stockage) {
		getStockages().remove(stockage);
		stockage.setVille(null);

		return stockage;
	}

}