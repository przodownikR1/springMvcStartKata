package pl.java.borowiec.aop.multi_inheritence;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  14-04-2013 17:37:31
 
 */
public class MaxCalculatorImpl implements MaxCalculator {

	@Override
	public double max(double a, double b) {
		double result = a >= b ? a : b;
		System.out.println("max(" + a + ", " + b + ") = " + result);
		return result;
	}

}
