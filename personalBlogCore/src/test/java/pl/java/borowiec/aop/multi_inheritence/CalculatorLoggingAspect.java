package pl.java.borowiec.aop.multi_inheritence;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/*
 * opis zasad
 * 1) execution(public * ArithmeticCalculator.*(..)) - wszyskie publiczne metody zadeklrowane w interfejsie
 * 2) execution(public double ArithmeticCalculator.*(..)) - te ktore zwracaja double + public
 * 3)execution(public double ArithmeticCalculator.*(double, ..)) - w ktorych 1 argument jest double
 * 4)execution(public double ArithmeticCalculator.*(double, double)) -
 */
/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  14-04-2013 17:53:58
 
 */
@Aspect
public class CalculatorLoggingAspect {

	// mozna ominac pelna sciezke jesli aspect znajduje sie w tym samym katalogu co target
	
	
	
	  @After("execution(* ArithmeticCalculator.add(..))")
	  public void logAfter(JoinPoint joinPoint) {
	  System.err.println("AFTER : The method " + joinPoint.getSignature().getName()
	  + "() ends");
	  }
	 

	@Before("within(pl.java.borowiec.aop.service.impl.ArithmeticCalculatorImpl)")
	public void logWithinBefore() {
		System.err.println(" Within The method add() begins");
	}

}
