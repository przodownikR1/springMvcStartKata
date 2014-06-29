package pl.java.borowiec.dao.ranking;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.borowiec.ranking.Ranking;
import pl.java.borowiec.ranking.RankingPK;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  30-03-2013 10:48:06
 
 */
public interface RankingDao extends JpaRepository<Ranking, RankingPK>{

}
