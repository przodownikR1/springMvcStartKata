package pl.java.borowiec.ranking;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 03-04-2013 20:16:13
 */
@Embeddable
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class RankingPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6572401093540210575L;
	private @NonNull String clazzName;
	private @NonNull Long objectId;

	


}