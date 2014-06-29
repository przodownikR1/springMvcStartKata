package pl.java.borowiec.aop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.borowiec.aop.service.CarMechanicService;
import pl.java.borowiec.aop.service.Customer;
import pl.java.borowiec.aop.service.ElectricianService;
import pl.java.borowiec.aop.service.SomethingWrongException;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 11:59:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aop.xml" })
public class CarMechanicTest {
	@Autowired
	private CarMechanicService carMechanicService;

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void bootstrapTest() {
		Assert.assertTrue(true);
		Assert.assertNotNull(carMechanicService);
	}

	@Test
	public void checkCarAopTest() throws SomethingWrongException {
		carMechanicService.checkVehicleState();
		try {
			carMechanicService.checkVehicleStart();
		} catch (SomethingWrongException swe) {
			Assert.assertTrue(true);
		}
		carMechanicService.checkEngine();

		carMechanicService.getReport("slawek borowiec paid");

		Customer customer = new Customer("slawek borowiec");
		System.out.println(carMechanicService.getBillToClient(customer));

		carMechanicService.getBillToClient(customer);
		carMechanicService.basicReport2Customer();

		carMechanicService.notifyCustomerAboutError();

		System.out.println(carMechanicService.getLocalization());

		CarMechanicService ser = (CarMechanicService) applicationContext.getBean("carMechanicService");
		ser.basicReport2Customer();
		System.err.println("-----------------------------------DECLARE PARENT -----------------------");
		ElectricianService electricianService = (ElectricianService) applicationContext.getBean("carMechanicService");
		System.err.println(electricianService.checkCiruit());

		// System.err.println(((ElectricianService) carMechanicService).checkCiruit());
		carMechanicService.getText("some Text");
		carMechanicService.getReport("slawek report");
	}
}
