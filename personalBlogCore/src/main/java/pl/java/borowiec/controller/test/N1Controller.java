package pl.java.borowiec.controller.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.java.borowiec.performance_problem.Car;
import pl.java.borowiec.performance_problem.Person;
import pl.java.borowiec.service.performance.N1PerformanceService;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 14-04-2013 10:50:56
 */
@Controller
@RequestMapping("n1")
public class N1Controller {
	private static final String VIEW_NAME = "performance/n1";

	private Person slawek, pawel;
	private Car ferrari, porsche, suzuki, fiat, polonez;

	private void init() {
		polonez = new Car("polonez", 17);
		suzuki = new Car("suzuki", 5);
		fiat = new Car("fiat", 12);
		ferrari = new Car("ferrari", 1);
		porsche = new Car("porsche", 2);
		List<Car> pawelCars = new ArrayList<Car>();
		List<Car> slawekCars = new ArrayList<Car>();
		slawekCars.add(polonez);
		slawekCars.add(fiat);
		slawekCars.add(suzuki);
		pawelCars.add(ferrari);
		pawelCars.add(porsche);
		slawek = new Person("slawek", "warszawa", slawekCars);
		pawel = new Person("pawel", "gdansk", pawelCars);
	}

	@Autowired
	private N1PerformanceService n1PerformanceService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String view(Model model) {
		if (n1PerformanceService.countPerson() == 0) {
			init();
			n1PerformanceService.savePerson(slawek);
			n1PerformanceService.savePerson(pawel);
		}
		List<Person> persons = new ArrayList<Person>();
		persons.add(n1PerformanceService.lastNameIsLike("slawek").get(0));
		model.addAttribute("persons", persons);
		return VIEW_NAME;

	}

	@RequestMapping(value = "/problem", method = RequestMethod.GET)
	public String viewProblem(Model model) {
		if (n1PerformanceService.countPerson() == 0) {
			init();
			n1PerformanceService.savePerson(slawek);
			n1PerformanceService.savePerson(pawel);
		}
		List<Person> persons = new ArrayList<Person>();
		persons.add(n1PerformanceService.findByName("slawek"));
		model.addAttribute("persons", persons);
		return VIEW_NAME;

	}
	
}
