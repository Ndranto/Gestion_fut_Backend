package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the utilisteur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisteur.findAll", query="SELECT u FROM Utilisteur u")
@Access(value=AccessType.FIELD)
public class Utilisteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"Use_Pw\"")
	private String use_Pw;
    @Id
	@Column(name="\"User_Id\"")
	private Integer user_Id;

	@Column(name="\"User_Name\"")
	private String user_Name;

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

}