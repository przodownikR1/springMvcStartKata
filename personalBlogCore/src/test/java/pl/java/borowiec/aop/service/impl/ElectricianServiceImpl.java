package pl.java.borowiec.aop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.java.borowiec.aop.service.ElectricianService;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  14-04-2013 10:27:24
 
 */

public class ElectricianServiceImpl implements ElectricianService{

	List<String> answer = new ArrayList(){{add("everything is ok ..");add("something is wrong");add("I don't know why car not start");}};
		
	@Override
	public String checkCiruit() {
		return "electic service  said :  " + answer.get(new Random().nextInt(2));
	}

	

}
