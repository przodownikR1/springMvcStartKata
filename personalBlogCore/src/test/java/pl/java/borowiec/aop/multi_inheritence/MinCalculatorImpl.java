package pl.java.borowiec.aop.multi_inheritence;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  14-04-2013 17:37:38
 
 */
public class MinCalculatorImpl implements MinCalculator {

	@Override
	public double min(double a, double b) {
		double result = a <= b ? a : b;
		System.out.println("min(" + a + ", " + b + ") = " + result);
		return result;
	}

}
