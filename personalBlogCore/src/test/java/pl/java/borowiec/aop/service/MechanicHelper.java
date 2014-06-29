package pl.java.borowiec.aop.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MechanicHelper {
 
	
/*	@Around("PointcutActionDef.serviceLog()")
	public Object performance(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(pjp.getSignature().getName());
		Object returnValue = pjp.proceed();
		sw.stop();
		System.err.println("  performance check : invoke ->  method : " + pjp.getSignature().getName() + "  time:  " + sw.prettyPrint());
		return returnValue;
	}

	@AfterThrowing(pointcut = "PointcutActionDef.serviceLog()", throwing = "ex")
	public Object logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
		System.err.println("after throwing !!!!!  --> SomethingWrong Exception catch....");
		String logPrefix = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	
		String[] parameterNames = signature.getParameterNames();
		Object[] parameterValues = joinPoint.getArgs();
		return ex;
	}
	
	@Before(value = "@annotation(check)")
    public void checkCar(JoinPoint joinPoint, Check check) {
      System.err.println("prepare check Car");
     
    }
	
	
	@After(value = "@annotation(check)")
    public void checkCarAfter(JoinPoint joinPoint, Check check) {
      System.err.println("finish check Car");
     
    }

	 @After(value="execution(public * get*())")
	 public void allGetters(){
		 System.err.println("GET ==== rules");
	 }*/
	/* @Before("PointcutActionDef.allMechanic()")
	 public void allMechanic(){
		 System.err.println("all mechanic ");
	 }*/
	
	/* @Before("PointcutActionDef.allMethodsWithoutArguments()")
	 public void allMethodsWithoutArguments(){
		 System.err.println("allMethodsWithoutArguments ");
	 }*/
	 
	/* @Before("PointcutActionDef.allMethodsWithOneParameterString()")
	 public void allMethodsWithOneParameterString(){
		 System.err.println("OneParameterString");
	 }*/
	
	@Before("PointcutActionDef.allMethodsWithCustomer()")
	public void allMethodsWithCustomer(){
		System.err.println("allMethodsWithCustomer");
	}
	
	@Before("PointcutActionDef.within()")
	public void withint(){
		System.err.println("within");
	}
	@After("PointcutActionDef.printReport(in)")
	public void printReport(String in){
		System.err.println("Print report ...... " +in);
	}
	@Before("PointcutActionDef.getterMethodsWithCustomerReturnType()")
	public void getterMethodsWithCustomerReturnType(){
		
		System.err.println("getterMethodsWithCustomerReturnType");
	}
/*	@Before("PointcutActionDef.allAfterMechanicService()")
	public void allAfterMechanicService(){
		System.err.println("allAfterMechanicService()");
	}*/
	
	 @Before("PointcutActionDef.methodsThatThrowSomethingWrongException()")
	 public void methodsThatThrowSomethingWrongException() {
		 System.err.println("methodsThatThrowSomethingWrongException()");
	 }
	
	
	 
		
	 
}
