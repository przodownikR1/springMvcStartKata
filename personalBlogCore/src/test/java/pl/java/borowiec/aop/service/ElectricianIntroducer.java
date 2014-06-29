package pl.java.borowiec.aop.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import pl.java.borowiec.aop.service.impl.ElectricianServiceImpl;
/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  14-04-2013 10:37:11
 
 */
@Aspect
public class ElectricianIntroducer {
	@DeclareParents( 
		      value = "pl.java.borowiec.aop.service.CarMechanicService+", 
		      defaultImpl = ElectricianServiceImpl.class)
		  public static ElectricianService electricianService;
}

