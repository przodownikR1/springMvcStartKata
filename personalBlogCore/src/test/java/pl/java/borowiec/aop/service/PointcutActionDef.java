package pl.java.borowiec.aop.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  13-04-2013 12:04:14
 
 */
@Aspect
public class PointcutActionDef {
	@Pointcut("execution(public * pl.java.borowiec.aop.service..*.*(..))")
	public void serviceLog() {}

	
	 @Pointcut("execution(* pl..CarMechanicService+.get*(*))")                        // 2
	 public void oneParamsInCarMechanic() {}    
	 
	 
	
	 @Pointcut("execution(*  pl.java.borowiec.aop.service.CarMechanicService.*(..))")                        // 2
	 public void allMechanic() {}    
	 
	 @Pointcut("execution(* *())")
	 public void allMethodsWithoutArguments() {}
	 
	 @Pointcut("execution(java.lang.String *(java.lang.String))")
	 public void allMethodsWithOneParameterString() {}
	 
	 
	 @Pointcut("execution(* *(..))")
	 public void allMethodsWithOneOrMoreArgumentRegarlessOfType() {}
	 
	 @Pointcut("args(pl.java.borowiec.aop.service.Customer)")
	 public void allMethodsWithCustomer(){};

	 @Pointcut("within(pl.java.borowiec.aop.service.CarMechanicService)")
	 public void within(){
		 
	 }

	 
	 @Pointcut("execution(execution(* *(java.lang.String)) && args(in)")
	 public void printReport(String in) {}
	 
	 @Pointcut("execution (pl.java.borowiec.aop.service.Customer notifyCustomerAboutError(..))")
	 public void getterMethodsWithCustomerReturnType() {}

	 @Pointcut("within(pl.java.borowiec.aop.service.CarMechanicService+)")
    public void allAfterMechanicService() {}
	 
    
	 @Pointcut("execution (* *(..) throws  pl.java.borowiec.aop.service.SomethingWrongException)")
	 public void methodsThatThrowSomethingWrongException() {}

	 
}
