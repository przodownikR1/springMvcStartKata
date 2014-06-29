package pl.java.borowiec.simple;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 15:27:45
 */
public class ApplicationContextTest {
	@Test
	public void initContextTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		String str = context.getBean("str", String.class);
		Assert.assertEquals("slawek", str);
	}

}
