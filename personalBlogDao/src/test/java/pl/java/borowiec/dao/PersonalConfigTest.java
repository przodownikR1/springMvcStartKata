package pl.java.borowiec.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.java.borowiec.dao.tag.TagDao;

public class PersonalConfigTest {

	@Test
	public void bootstrapAppFromXml() {

		ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
		ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) context;
		ctx.getEnvironment().setActiveProfiles("spring-data-test");
		ctx.refresh();
		assertThat(context, is(notNullValue()));
		assertThat(context.getBean(TagDao.class), is(notNullValue()));
	}

}
