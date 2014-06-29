package pl.java.borowiec.aop.multi_inheritence;

import pl.java.borowiec.aop.multi_inheritence.SomeObject;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  14-04-2013 17:36:35
 
 */
public interface ArithmeticCalculator {
	public double add(double a, double b);

	public double sub(double a, double b);

	public double mul(double a, double b);

	public double div(double a, double b);

	public void someExecution(String name,SomeObject so, double digit);

}