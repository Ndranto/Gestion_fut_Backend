package model;

import java.io.Serializable;

public class Categories implements Serializable{
private Long idCategorie;
 private String nameCatégorie;
 private String photo;
public Long getIdCategorie() {
	return idCategorie;
}
public void setIdCategorie(Long idCategorie) {
	this.idCategorie = idCategorie;
}
public String getNameCatégorie() {
	return nameCatégorie;
}
public void setNameCatégorie(String nameCatégorie) {
	this.nameCatégorie = nameCatégorie;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public Categories(Long idCategorie, String nameCatégorie, String photo) {
	super();
	this.idCategorie = idCategorie;
	this.nameCatégorie = nameCatégorie;
	this.photo = photo;
}
public Categories() {
	super();
	// TODO Auto-generated constructor stub
}
 
	
}
