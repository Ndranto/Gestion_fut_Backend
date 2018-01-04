package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the "stockage_History" database table.
 * 
 */
@Entity
@Access(value=AccessType.FIELD)
@Table(name="\"stockage_History\"")
@NamedQuery(name="Stockage_History.findAll", query="SELECT s FROM Stockage_History s")
public class Stockage_History implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_hist")
	private Integer idHist;

	@Temporal(TemporalType.DATE)
	@Column(name="\"id_date_Hist\"")
	private Date id_date_Hist;

	@ManyToOne(optional = false)
	@JoinColumn(name="stock_Id", referencedColumnName="stock_Id",insertable =false , updatable = false)
	private Stockage stockage;

	@Column(name="\"Total\"")
	private double total;

	public Stockage_History() {
	}

	public Integer getIdHist() {
		return this.idHist;
	}

	public void setIdHist(Integer idHist) {
		this.idHist = idHist;
	}

	public Date getId_date_Hist() {
		return this.id_date_Hist;
	}

	public void setId_date_Hist(Date id_date_Hist) {
		this.id_date_Hist = id_date_Hist;
	}

	public Stockage getStockId() {
		return this.stockage;
	}

	public void setStockId(Stockage stockId) {
		this.stockage = stockId;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}