package pl.java.borowiec.jpa.performance;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.common.dao.jpa.performance.CarDao;
import pl.java.borowiec.common.dao.jpa.performance.PersonDao;
import pl.java.borowiec.performance_problem.Car;
import pl.java.borowiec.performance_problem.Person;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 09-04-2013 00:28:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao.xml" })
@ActiveProfiles("jpa")
@Transactional
public class NPlusOneProblemTest {
	static final Logger LOGGER = LoggerFactory.getLogger(NPlusOneProblemTest.class);
	@Autowired
	private CarDao carDao;
	@Autowired
	private PersonDao personDao;

	private Person slawek;
	private Person pawel;

	private Car polonez;

	private Car suzuki;

	private Car fiat;

	private Car ferrari, porche;
	private long countBefore;

	@Before
	public void init() {
		polonez = new Car("polonez", 17);
		suzuki = new Car("suzuki", 5);
		fiat = new Car("fiat", 12);

		ferrari = new Car("ferrari", 1);
		porche = new Car("porche", 2);
		List<Car> pawelCars = new ArrayList<Car>();
		List<Car> slawekCars = new ArrayList<Car>();
		slawekCars.add(polonez);
		slawekCars.add(fiat);
		slawekCars.add(suzuki);
		pawelCars.add(ferrari);
		pawelCars.add(porche);
		slawek = new Person("slawek", "warszawa", slawekCars);
		pawel = new Person("pawel", "gdansk", pawelCars);
		countBefore = personDao.countAll();
		personDao.save(pawel);
		personDao.save(slawek);

	}

	@Test
	public void nProblemTest() {
		assertEquals(2, personDao.countAll());
		List<Person> persons = personDao.getAll();

		for (Person person : persons) {
			LOGGER.info("person : {}", person);
			LOGGER.info("================= SLAWEK CARS================");
			for (Car car : person.getCars()) {
				LOGGER.info("{} car is : {} ", person.getName(), car);
			}
		}

	}
	@Test
	public void wrapperTest(){
		BeanWrapper osoba = new BeanWrapperImpl(new Person());
		osoba.setPropertyValue("name", "Slawek");
		BeanWrapper car = new BeanWrapperImpl(new Car());
		osoba.setPropertyValue("cars[0]", car.getWrappedInstance());
		PropertyValue value = new PropertyValue("cars[0].make", "jelcz");
		osoba.setPropertyValue(value);
		
		
		Person o = (Person) osoba.getWrappedInstance();
		System.err.println(o);

	}
}
