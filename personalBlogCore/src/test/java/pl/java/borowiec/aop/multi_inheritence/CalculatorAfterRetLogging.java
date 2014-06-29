package pl.java.borowiec.aop.multi_inheritence;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;


/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  14-04-2013 17:37:12
 
 */
@Aspect
public class CalculatorAfterRetLogging {
	@AfterReturning(pointcut = "execution(* pl.java.borowiec.aop.multi_inheritence.*(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.err.println("AfterReturning : The method " + joinPoint.getSignature().getName() + "() ends with " + result);
	}
}
