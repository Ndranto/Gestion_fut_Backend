package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cli_id_client")
	private Integer cliIdClient;

	@Column(name="cli_adresse")
	private String cliAdresse;

	@Column(name="cli_nom")
	private String cliNom;

	@Column(name="cli_solde_client")
	private Integer cliSoldeClient;

	@Column(name="ville_id_ville")
	private Integer villeIdVille;

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

	public Integer getVilleIdVille() {
		return this.villeIdVille;
	}

	public void setVilleIdVille(Integer villeIdVille) {
		this.villeIdVille = villeIdVille;
	}

}