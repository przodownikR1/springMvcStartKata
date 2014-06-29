package pl.java.borowiec.aop.multi_inheritence;




/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  14-04-2013 17:53:49
 
 */
public  class ArithmeticCalculatorImpl implements ArithmeticCalculator {
	@Override
	public double add(double a, double b) {
		double result = a + b;
		System.out.println(a + " + " + b + " = " + result);
		return result;
	}

	@Override
	public double sub(double a, double b) {
		double result = a - b;
		System.out.println(a + " - " + b + " = " + result);
		return result;
	}

	@Override
	public double mul(double a, double b) {
		double result = a * b;
		System.out.println(a + " * " + b + " = " + result);
		return result;
	}

	@Override
	public double div(double a, double b) {
		if (b == 0)
			throw new IllegalArgumentException("Division by zero");
		double result = a / b;
		System.out.println(a + " / " + b + " = " + result);
		return result;
	}


	@Override
	public void someExecution(String name, SomeObject so, double digit) {
		// TODO Auto-generated method stub
		
	}

	

}
