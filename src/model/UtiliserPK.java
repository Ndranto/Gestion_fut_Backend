package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the utiliser database table.
 * 
 */
@Embeddable
public class UtiliserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="inv_id", insertable=false, updatable=false)
	private Integer invId;

	@Column(name="trans_id", insertable=false, updatable=false)
	private Integer transId;

	public UtiliserPK() {
	}
	public Integer getInvId() {
		return this.invId;
	}
	public void setInvId(Integer invId) {
		this.invId = invId;
	}
	public Integer getTransId() {
		return this.transId;
	}
	public void setTransId(Integer transId) {
		this.transId = transId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UtiliserPK)) {
			return false;
		}
		UtiliserPK castOther = (UtiliserPK)other;
		return 
			this.invId.equals(castOther.invId)
			&& this.transId.equals(castOther.transId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.invId.hashCode();
		hash = hash * prime + this.transId.hashCode();
		
		return hash;
	}
}