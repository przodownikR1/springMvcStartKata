package pl.java.borowiec.ranking;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 03-04-2013 20:16:13
 */
@Embeddable
public class RankingPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6572401093540210575L;
	private String clazzName;
	private long objectId;

	public RankingPK() {
		super();
	}

	public RankingPK(String clazzName, long objectId) {
		super();
		this.clazzName = clazzName;
		this.objectId = objectId;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clazzName == null) ? 0 : clazzName.hashCode());
		result = prime * result + (int) (objectId ^ (objectId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RankingPK other = (RankingPK) obj;
		if (clazzName == null) {
			if (other.clazzName != null)
				return false;
		} else if (!clazzName.equals(other.clazzName))
			return false;
		if (objectId != other.objectId)
			return false;
		return true;
	}

}