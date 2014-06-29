/**
 * 
 */
package pl.java.borowiec.ranking;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 30-03-2013 01:09:00
 */
@Entity
public class Ranking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1679567754138176183L;
	@EmbeddedId
	private RankingPK rankingPK;
	private String userName;
	private int point;
	private float summaryResult;

	public Ranking() {
		super();
	}

	public Ranking(RankingPK rankingPK) {
		super();
		this.rankingPK = rankingPK;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public float getSummaryResult() {
		return summaryResult;
	}

	public void setSummaryResult(float summaryResult) {
		this.summaryResult = summaryResult;
	}

	public RankingPK getRankingPK() {
		return rankingPK;
	}

	public void setRankingPK(RankingPK rankingPK) {
		this.rankingPK = rankingPK;
	}

}
