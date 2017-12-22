package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ligne_inventaire database table.
 * 
 */
@Embeddable
public class LigneInventairePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="inv_id", insertable=false, updatable=false)
	private Integer invId;

	@Column(name="fut_id", insertable=false, updatable=false)
	private Integer futId;

	public LigneInventairePK() {
	}
	public Integer getInvId() {
		return this.invId;
	}
	public void setInvId(Integer invId) {
		this.invId = invId;
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
		if (!(other instanceof LigneInventairePK)) {
			return false;
		}
		LigneInventairePK castOther = (LigneInventairePK)other;
		return 
			this.invId.equals(castOther.invId)
			&& this.futId.equals(castOther.futId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.invId.hashCode();
		hash = hash * prime + this.futId.hashCode();
		
		return hash;
	}
}