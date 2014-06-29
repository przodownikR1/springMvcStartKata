package pl.java.borowiec.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.dao.ranking.RankingDao;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 30-03-2013 11:09:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao.xml" })
@Transactional
@ActiveProfiles("spring-data-test")
public class RankingDaoTest extends InitExampleObject {
	@Autowired
	private RankingDao rankingDao;

	@Test
	public void initTest() {
		Assert.assertNotNull(rankingDao);
	}

	@Test
	public void persistTest() {
		rankingDao.save(ranking1);
		rankingDao.save(ranking2);
		rankingDao.flush();
		assertNotNull(rankingDao.findOne(rankPk1));
	}
}
