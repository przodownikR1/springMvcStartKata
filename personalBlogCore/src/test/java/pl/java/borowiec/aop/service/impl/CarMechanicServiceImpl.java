package pl.java.borowiec.aop.service.impl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import pl.java.borowiec.aop.service.CarMechanicService;
import pl.java.borowiec.aop.service.Check;
import pl.java.borowiec.aop.service.Customer;
import pl.java.borowiec.aop.service.SomethingWrongException;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  13-04-2013 11:57:13
 
 */

@Component
public class CarMechanicServiceImpl implements CarMechanicService{
	static final Logger LOGGER = LoggerFactory.getLogger(CarMechanicServiceImpl.class);
	

	
	private String localization;
	@Override
	@Check
	public void checkVehicleState() {
		LOGGER.info("+++ right impl  +++ : checkVehicleState()");
		try {
			Thread.sleep(TimeUnit.SECONDS.toSeconds(3));
		} catch (InterruptedException e) {
		
		}
		
	}

	@Override
	public String basicReport2Customer() {
		LOGGER.info("+++ right impl  +++ : basicReport2Customer()");
		return "Ok , everything is perfect now ... ";
	}

	@Override
	public String basicReport2RightCustomer(Customer customer) {
		LOGGER.info("+++ right impl  +++ : basicReport2Customer(Customer)");
		return "Ok Mr "+  customer.getName()  +", everything is perfect now ... ";
	}

	@Override
	public void checkEngine() {
		LOGGER.info("+++ right impl  +++ :checkEngine()");
		try {
			Thread.sleep(TimeUnit.SECONDS.toSeconds(2));
		} catch (InterruptedException e) {
		
		}
	}

	@Override
	@Check
	public void checkVehicleStart() throws SomethingWrongException {
		   LOGGER.info("+++ right impl  +++ :checkVehicleStart()");
		   throw new SomethingWrongException("starter error");
	}

	@Override
	public Customer notifyCustomerAboutError() {
		LOGGER.info("+++ right impl  +++ :notifyCustomer()");
		Customer customer = new Customer("slawek borowiec");
		return customer;
	}

	@Override
	public String getReport(String in) {
		LOGGER.info("+++ right impl  +++ :getReport()");
		return "getReport .............................";
	}

	@Override
	public String getBillToClient(Customer customer) {
		LOGGER.info("+++ right impl  +++ :getBillToClient()");
		return "you own me 14$";
	}

	public String getLocalization() {
		LOGGER.info("+++ right impl  +++ :getLocalication()");
		return localization;
	}

	@Override
	public void getText(String str) {
		LOGGER.info("+++ right impl  +++ :getText()");
		
	}


}
