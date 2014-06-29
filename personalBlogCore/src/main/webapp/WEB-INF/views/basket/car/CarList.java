package org.java.controller.car;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.java.domain.car.Car;

/**
 * @author Sławomir Borowiec 
 * Module name : performanceSpring
 * Creating time :  03-07-2013 11:13:21
 
 */
@Data
public class CarList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5402295288207803928L;
	List<Car> cars = new ArrayList<>();

	
	
	
}
