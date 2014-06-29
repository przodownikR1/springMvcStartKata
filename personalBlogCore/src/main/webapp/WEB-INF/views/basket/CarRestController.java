package pl.java.JCodeLeader.core.contollers.experimental.car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import pl.java.JCodeLeader.core.contollers.basic.BaseController;
import pl.java.JCodeLeader.core.contollers.experimental.car.bean.JavaBean;
import pl.java.JCodeLeader.core.contollers.experimental.car.event.CarEvent;
import pl.java.JCodeLeader.core.contollers.experimental.car.view.CarAtomView;
import pl.java.JCodeLeader.core.contollers.experimental.car.view.CarRssView;
import pl.java.JCodeLeader.core.exception.RestException;
import pl.java.JCodeLeader.core.services.experimental.car.CarService;
import pl.java.JCodeLeader.core.services.experimental.car.dto.Cars;
import pl.java.JCodeLeader.experimental.rest.Car;

@Controller
@RequestMapping("/car")
public class CarRestController extends BaseController implements ApplicationEventPublisherAware {
	private static final String BASEURL = "http://localhost:9090/tripCore/";
	private final static String VIEW_NAME = "carView";
	private final static String VIEW_NAME_UPDATE = "carUpdateView";
	@Autowired
	private CarService carService;

	private ApplicationEventPublisher applicationEventPublisher;


	@RequestMapping(value = "/faktura", method = RequestMethod.GET)
	public ModelAndView getFaktura()  {
		throw new RestException("test rest exception -> @Exception works ?");

	}
		
	@ExceptionHandler
	public @ResponseBody String handle(RestException e) {
		return  e.getMessage();
	}
	
	@RequestMapping(value="/entity/status", method=RequestMethod.GET)
	public ResponseEntity<String> responseEntityStatusCode() {
		return new ResponseEntity<String>("The String ResponseBody with custom status code (403 Forbidden)",
				HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value="/entity/headers", method=RequestMethod.GET)
	public ResponseEntity<String> responseEntityCustomHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("The String ResponseBody with custom header Content-Type=text/plain", headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/mapping/consumes", method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody String byConsumes(@RequestBody JavaBean javaBean) {
		return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
	}

	@RequestMapping(value="/mapping/produces", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody JavaBean byProduces() {
		return new JavaBean();
	}
	

	/************************************************************************/
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
		Car car = carService.getCarById(id);
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
			car = carService.getCarById(id);
		} else {
			car = new Car();
		}
		model.addAttribute("car", car);
		CarEvent ce = new CarEvent(this, car.getName(), car.getPrice());
		applicationEventPublisher.publishEvent(ce);
		return new ModelAndView(VIEW_NAME_UPDATE, model.asMap());
	}

	@RequestMapping(value = "/edit/{id}", method = { RequestMethod.POST })
	public ModelAndView getHandlePOST(@ModelAttribute("car") @Valid Car car, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return new ModelAndView(VIEW_NAME_UPDATE);
		}
		carService.updateCar(car);
		model.addAttribute("cars", carService.getCars());
		return new ModelAndView(VIEW_NAME);
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public String deleteCar(@PathVariable("id") long id) {
		Car car = carService.getCarById(id);
		this.carService.deleteCar(car);
		return "redirect:/car/all";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getCarsRest(Model model) {
		List<Car> cars = carService.getCars();
		model.addAttribute("cars", cars);
		return new ModelAndView(VIEW_NAME, model.asMap());
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView saveCar(@ModelAttribute("car") @Valid Car car, BindingResult result, Model model, HttpServletResponse response) {
		if (result.hasErrors()) {
			return new ModelAndView(VIEW_NAME_UPDATE);
		}
		carService.persistCar(car);
		model.addAttribute("cars", carService.getCars());
		return new ModelAndView(VIEW_NAME);
	}

	/*-------------------------------REST-----------------------------*/
	@RequestMapping(value = "/rest/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody
	Car getCarRest(@PathVariable("id") long id) {
		Car car = carService.getCarById(id);
		return car;
	}

	@RequestMapping(value = "/rest/all", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody
	List<Car> getAllCarRest() {
		List<Car> cars = carService.getCars();
		return cars;
	}

	@RequestMapping(value = "/rest/cars", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Cars getCarsRest() {

		return carService.getAllCar();
	}

	@RequestMapping(value = "/rest/remove/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCarRest(@PathVariable("id") long id) {
		Car car = carService.getCarById(id);
		this.carService.deleteCar(car);
	}

	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody
	//w arg metody  @RequestBody final Car
	Car updateCarRest(@Valid Car car, BindingResult result, HttpServletResponse response) throws BindException {
		if (result.hasErrors()) {
			throw new BindException(result);
		}
		carService.updateCar(car);
		response.setHeader("Location", "/car/" + car.getId());
		return car;
	}

	@RequestMapping(value = "/rest", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	//w arg metody  @RequestBody final Car
	Car saveCarRest(@Valid Car car, BindingResult result, HttpServletResponse response) throws BindException {
		if (result.hasErrors()) {
			throw new BindException(result);
		}
		carService.persistCar(car);
		response.setHeader("Location", "/car/" + car.getId());
		return car;
	}

	@ExceptionHandler(RestException.class)
	public String handleIOException(IOException ex, HttpServletRequest request) {
		String clazzName = ClassUtils.getShortName(ex.getClass());
		return clazzName;
	}

	/************************************ ATOM FEED **************************************/

	@RequestMapping("/atomfeed")
	public ModelAndView getAtomFeed(Model model) {
		List<Car> cars = carService.getCars();
		model.addAttribute("cars", cars);
		return new ModelAndView(new CarAtomView(), model.asMap());
	}

	@RequestMapping("/rssfeed")
	public ModelAndView getRSSFeed(Model model) {
		List<Car> cars = carService.getCars();
		model.addAttribute("cars", cars);
		return new ModelAndView(new CarRssView(), model.asMap());
	}

	/******************************* REST_TEMPLATE *********************************************/
	@RequestMapping(value = "/restTemplate/{id}", method = RequestMethod.GET)
	public ModelAndView retrieveCars(@PathVariable Long id, Model model) {
		Map<String, Long> urlVariables = new HashMap<String, Long>();
		urlVariables.put("id", id);
		Car car = new RestTemplate().getForObject(BASEURL + "car/rest/{id}", Car.class, urlVariables);
		List<Car> cars = Collections.emptyList();
		cars.add(car);
		model.addAttribute("cars", cars);
		return new ModelAndView(VIEW_NAME, model.asMap());
	}

	@RequestMapping(value = "/restTemplateTest/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Car retrieveCarsTest(@PathVariable Long id, Model model) {
		ResponseEntity<Car> response = new RestTemplate().exchange(BASEURL + "car/rest/{id}", HttpMethod.GET, null, Car.class, id);
		Car car = response.getBody();
		return car;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;

	}
}
