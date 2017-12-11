package model;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Fut {
	private Long Fut_Id;
	private String Fut_Name;
	private boolean Fut_Etat;
	private Categories categorie;
	public Long getFut_Id() {
		return Fut_Id;
	}
	@JsonIgnore
	public Categories getCategorie() {
		return categorie;
	}
	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}
	public void setFut_Id(Long fut_Id) {
		Fut_Id = fut_Id;
	}
	public String getFut_Name() {
		return Fut_Name;
	}
	public void setFut_Name(String fut_Name) {
		Fut_Name = fut_Name;
	}
	public boolean isFut_Etat() {
		return Fut_Etat;
	}
	public void setFut_Etat(boolean fut_Etat) {
		Fut_Etat = fut_Etat;
	}
	public Fut(Long fut_Id, String fut_Name, boolean fut_Etat) {
		super();
		Fut_Id = fut_Id;
		Fut_Name = fut_Name;
		Fut_Etat = fut_Etat;
	}
	public Fut(Long fut_Id, String fut_Name, boolean fut_Etat,Categories categorie) {
		super();
		Fut_Id = fut_Id;
		Fut_Name = fut_Name;
		Fut_Etat = fut_Etat;
		this.categorie = categorie;
	}
	public Fut() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
