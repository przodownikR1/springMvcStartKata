package pl.java.borowiec.aop.multi_inheritence;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  14-04-2013 17:37:44
 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:multipleInheritence.xml" })
public class MultipleCalculatorTest {
	@Autowired
	private CalculatorIntroduction calculatorIntroduction;

	@Autowired
	private ArithmeticCalculator arithmeticCalculator;

	@Test
	public void initTest() {
		Assert.assertNotNull(calculatorIntroduction);
		Assert.assertNotNull(arithmeticCalculator);
	}

	@Test
	public void multipleBehaveTest() {
		MaxCalculator maxCalculator = (MaxCalculator) arithmeticCalculator;
		System.err.println(maxCalculator.max(1, 2));
		MinCalculator minCalculator = (MinCalculator) arithmeticCalculator;
		System.err.println(minCalculator.min(1, 2));
		arithmeticCalculator.add(3, 4);
	}
}
