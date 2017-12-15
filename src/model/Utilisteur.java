package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the utilisteur database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Utilisteur.findAll", query="SELECT u FROM Utilisteur u"),
@NamedQuery(name="Utilisteur.findAll", query="SELECT u FROM Utilisteur u"),})
public class Utilisteur implements Serializable {
	private static final long serialVersionUID = 1L;
  
	
	@Column(name="\"Use_Pw\"")
	private String use_Pw;

	@Column(name="\"User_Name\"")
	private String user_Name;

	 @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="\"User_Id\"")
	private int user_Id;
	 
	public Utilisteur() {
	}

	public String getUse_Pw() {
		return this.use_Pw;
	}

	public void setUse_Pw(String use_Pw) {
		this.use_Pw = use_Pw;
	}

	public Integer getUser_Id() {
		return this.user_Id;
	}

	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}

	public String getUser_Name() {
		return this.user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String toString() {
		return "User [id=" + user_Id + ", Name=" + user_Name + ", pw="
		+ use_Pw + "]";
		}
}