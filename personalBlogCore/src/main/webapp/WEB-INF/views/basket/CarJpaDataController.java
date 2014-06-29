package pl.java.JCodeLeader.core.contollers.experimental.car;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import pl.java.JCodeLeader.core.contollers.basic.BaseController;
import pl.java.JCodeLeader.core.services.experimental.car.CarJpaDataService;
import pl.java.JCodeLeader.experimental.rest.Car;

@Controller
@RequestMapping("/carJpaData")
public class CarJpaDataController  extends BaseController {
	private final static String VIEW_NAME = "carView";
	private final static String VIEW_NAME_UPDATE = "carUpdateView";
	private final static String VIEW_NAME_SEARCH = "carFindView";
	@Autowired
	private CarJpaDataService carJpaDataService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getCar(Model model) {
		Car car = new Car();
		model.addAttribute("car", car);
		return new ModelAndView(VIEW_NAME_UPDATE, model.asMap());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getCarById(@PathVariable("id") long id, Model model, HttpServletRequest request) throws ServletRequestBindingException {
		String displayName = RequestContextUtils.getWebApplicationContext(request).getDisplayName();
		long test = ServletRequestUtils.getLongParameter(request, "id");
		System.err.println(" ServletRequestUtils.getLongParameter(request, id);  " + test + "  " + displayName);
		// WebUtils
		Car car = carJpaDataService.findCarById(id);
		List<Car> cars = new ArrayList<Car>(1);
		cars.add(car);
		model.addAttribute("cars", cars);
		return new ModelAndView(VIEW_NAME, model.asMap());
	}

	@RequestMapping(value = "/edit/{id}", method = { RequestMethod.GET })
	public ModelAndView getHandle(@PathVariable Long id, Model model) {
		Assert.notNull(id);
		Car car = null;
		if (id != null) {
			car = carJpaDataService.findCarById(id);
		} else {
			car = new Car();
		}
		model.addAttribute("car", car);
		return new ModelAndView(VIEW_NAME_UPDATE, model.asMap());
	}

	@RequestMapping(value = "/edit/{id}", method = { RequestMethod.POST })
	public ModelAndView getHandlePOST(@ModelAttribute("car") @Valid Car car, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return new ModelAndView(VIEW_NAME_UPDATE);
		}
		carJpaDataService.updateCar(car);
		model.addAttribute("cars", carJpaDataService.getCars());
		return new ModelAndView(VIEW_NAME);
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public String deleteCar(@PathVariable("id") long id) {
		Car car = carJpaDataService.findCarById(id);
		this.carJpaDataService.removeCar(car);
		return "redirect:/car/all";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getCarsRest(Model model) {
		Iterable<Car> cars = carJpaDataService.getCars();
		List<Car> carsList = new ArrayList<Car>();
		while(cars.iterator().hasNext()){
			carsList.add(cars.iterator().next());
		}
		model.addAttribute("cars", cars);
		return new ModelAndView(VIEW_NAME, model.asMap());
	}

	
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public ModelAndView findCar(@ModelAttribute("car") @Valid Car car, BindingResult result, Model model, HttpServletResponse response) {
		if (result.hasErrors()) {
			return new ModelAndView(VIEW_NAME_SEARCH);
		}
		List<Car> cars =  carJpaDataService.getCarByName(car.getName());
		model.addAttribute("cars", cars);
		return new ModelAndView(VIEW_NAME);
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ModelAndView findCarGet( Model model) {
		Car car = new Car();
		model.addAttribute("car", car);
		return new ModelAndView(VIEW_NAME_SEARCH, model.asMap());
	}

	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView saveCar(@ModelAttribute("car") @Valid Car car, BindingResult result, Model model, HttpServletResponse response) {
		if (result.hasErrors()) {
			return new ModelAndView(VIEW_NAME_UPDATE);
		}
		carJpaDataService.persistCar(car);
		model.addAttribute("cars", carJpaDataService.getCars());
		return new ModelAndView(VIEW_NAME);
	}

}
