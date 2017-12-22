package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the stocker database table.
 * 
 */
@Embeddable
public class StockerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="stock_id", insertable=false, updatable=false)
	private Integer stockId;

	@Column(name="fut_id", insertable=false, updatable=false)
	private Integer futId;

	public StockerPK() {
	}
	public Integer getStockId() {
		return this.stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	public Integer getFutId() {
		return this.futId;
	}
	public void setFutId(Integer futId) {
		this.futId = futId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StockerPK)) {
			return false;
		}
		StockerPK castOther = (StockerPK)other;
		return 
			this.stockId.equals(castOther.stockId)
			&& this.futId.equals(castOther.futId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.stockId.hashCode();
		hash = hash * prime + this.futId.hashCode();
		
		return hash;
	}
}