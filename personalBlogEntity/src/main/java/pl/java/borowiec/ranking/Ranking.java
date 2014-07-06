/**
 * 
 */
package pl.java.borowiec.ranking;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Ranking implements Serializable {

	private static final long serialVersionUID = -1679567754138176183L;
	
	@EmbeddedId
	private @NonNull RankingPK rankingPK;
	private String userName;
	private int point;
	private float summaryResult;

}
