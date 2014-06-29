package pl.java.borowiec.spel;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.borowiec.ad.Ad;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 01:16:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spel.xml" })
@ActiveProfiles("slawek")
public class SpElTest {
	static final Logger LOGGER = LoggerFactory.getLogger(SpElTest.class);
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private String str;

	@Resource
	private List<String> ads;

	@Value("#{systemProperties['user.home']}")
	private String userValue;

	@Value("#{default['slawek']}")
	private String slawekName;

	@Autowired
	private Environment environment;

	@Value("#{ads[3].name?.toUpperCase()}")
	private String adSamsung;

	@Value("#{T(java.lang.Math).PI}")
	private float PI;
	@Value("#{ads[T(java.lang.Math).random()*ads.size()].name}")
	private String randAd;
	@Value("#{ads.?[price gt 300] }")
	private List<Ad> criteriaPrice;
	@Value("#{ads.![name] }")
	private List<String> adNames;

	@Value("#{ads.![name + ' : ' +price] }")
	private List<String> adNameAndPrice;

	@Value("#{automakers.?[startsWith('M')]}")
	private List<String> cars;

	@Test
	public void bootstrapTest() {
		Assert.assertTrue(true);
		LOGGER.info(ads.getClass().getSimpleName());
		LOGGER.info(Arrays.toString(applicationContext.getBeanDefinitionNames()));
	}

	@Test
	@Ignore
	public void showEnvTest() {
		for (Entry<String, String> entry : System.getenv().entrySet()) {
			LOGGER.info("key {} - value {}", entry.getKey(), entry.getValue());
		}
	}

	@Test
	public void initStrTest() {
		Assert.assertNotNull(str);
	}

	@Test
	public void initTest() {
		Assert.assertNotNull(ads);
		Assert.assertEquals(5, ads.size());
	}

	@Test
	public void slawekSaidTest() {
		LOGGER.info(userValue);
		Assert.assertTrue(true);
	}

	@Test
	public void slawekNameTest() {
		LOGGER.info("slawekName : {}", slawekName);
		Assert.assertTrue(true);
	}

	@Test
	public void envTest() {
		LOGGER.info("active profile {}", Arrays.toString(environment.getActiveProfiles()));
		Assert.assertTrue(true);
	}

	@Test
	public void samsungTest() {
		Assert.assertEquals("SAMSUNG", adSamsung);
		LOGGER.info("ad -> samsung : {}", adSamsung);
	}

	@Test
	public void spelTest() {
		LOGGER.info("PI :  {}", PI);
		LOGGER.info("random Ad : {}", randAd);
		for (Ad ad : criteriaPrice) {
			LOGGER.info("{}", ad);
		}
		for (String name : adNames) {
			LOGGER.info("name : {}", name);
		}

		for (String name : adNameAndPrice) {
			LOGGER.info("name+price : {}", name);
		}
		for (String name : cars) {
			LOGGER.info("car : {}", name);
		}

	}

}
