package pl.java.borowiec.aop.multi_inheritence;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;



/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  14-04-2013 17:53:54
 
 */
@Aspect
public class CalculatorIntroduction {
	@DeclareParents(value = "pl.java.borowiec.aop.multi_inheritence.ArithmeticCalculatorImpl", defaultImpl = MaxCalculatorImpl.class)
	public MaxCalculator maxCalculator;
	@DeclareParents(value = "pl.java.borowiec.aop.multi_inheritence.ArithmeticCalculatorImpl", defaultImpl = MinCalculatorImpl.class)
	public MinCalculator minCalculator;
}