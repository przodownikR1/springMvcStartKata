package org.java.controller.car;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.java.domain.car.Car;
import org.java.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefaults;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplate;

@Controller
@Slf4j
@RequestMapping(CarController.ACTION_URL)
public class CarController{
	protected static final String ACTION_URL = "/cars";
	private static final String ADD_CAR_VIEW = "cars/addCar";
	private static final String PAGINATION_CAR_VIEW = "cars/pagination";
	private static final String CAR_OBJECT = "car";
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private RestTemplate restTemplate;

	@Resource
	private org.springframework.core.io.Resource xmlExample;

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE })
	public @ResponseBody List<Car> cars() { 
		return carService.getAll();
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/show")
	public  List<Car> carsShow() {
		return carService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/pagination")
	public String  carPagination(@PageableDefaults(value = 50, pageNumber = 0) Pageable pageable, Model model) {
		Page<Car> cars = carService.findAllByPage(pageable);
		model.addAttribute("page", cars);
		log.info("++++										cars {}",cars);
		return PAGINATION_CAR_VIEW;
	}
	
	
	

	@SuppressWarnings("null")
	@RequestMapping(value = "/getallCar", method = RequestMethod.GET)
	public CarList getAll(Model model) {
		log.debug("Retrieve all cars");
		List<MediaType> acceptableMediaTypes  = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<CarList> entity = new HttpEntity<>(headers);
		ResponseEntity<CarList> result = null;
		try {
			result = restTemplate.exchange("http://localhost:8080/cars/", HttpMethod.GET, entity, CarList.class);
			// Add to model
			model.addAttribute("cars", result.getBody().cars);

		} catch (Exception e) {
			log.error("{}", e);
		}

		return result.getBody();
	}

	@SuppressWarnings("resource")
	@RequestMapping(value = "/carPicture/{id}", method = RequestMethod.GET, headers = "Accept=image/jpeg, image/jpg, image/png, image/gif")
	public @ResponseBody
	byte[] getPhoto(@PathVariable("id") Long id) {

		try {
			InputStream is = this.getClass().getResourceAsStream("/image/compass.jpg");

			BufferedImage img = ImageIO.read(is);

			ByteArrayOutputStream bao = new ByteArrayOutputStream();

			ImageIO.write(img, "jpg", bao);

			log.debug("Retrieving photo as byte array image");
			return bao.toByteArray();

		} catch (IOException e) {
			log.error("{}", e);
			throw new RuntimeException(e);
		}
	}

	@RequestMapping(value = "/getphoto", method = RequestMethod.GET)
	public void getPhoto(@RequestParam("id") Long id, HttpServletResponse response) {
		log.debug("Retrieve photo with id: " + id);

		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.IMAGE_JPEG);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		Map<String, Long> map = new HashMap<>();
		map.put("id", id);
		ResponseEntity<byte[]> result = restTemplate.exchange("http://localhost:8080/cars/carPicture/{id}", HttpMethod.GET, entity, byte[].class, map);

		// Display the image
		Writer.write(response, result.getBody());
	}

	@SuppressWarnings("null")
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Car getCar(@PathVariable("id") Long id, Model model) {
		log.debug("Retrieve car with id: " + id);
		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<Car> entity = new HttpEntity<>(headers);
		ResponseEntity<Car> result = null;
		try {
			result = restTemplate.exchange("http://localhost:8080/cars/{id}", HttpMethod.GET, entity, Car.class, id);
			// Add to model
			model.addAttribute("person", result.getBody());

		} catch (Exception e) {
			log.error("{}", e);
		}

		return result.getBody();
	}
    @SuppressWarnings("boxing")
	@RequestMapping(value="/update/car/{id}",method = RequestMethod.GET)
	public String updateCarNormal(Model model , @PathVariable("id")Long id){
    	model.addAttribute(carService.findById(id));
		return ADD_CAR_VIEW;
	}
    
    
    @RequestMapping(value="/update/car/{id}",method = RequestMethod.POST)
	public String updateCarNormal(@ModelAttribute(CAR_OBJECT)Car car,BindingResult result) throws Exception{
    	if(result.hasErrors()){
    		return ADD_CAR_VIEW;
    	}
        carService.update(car);    
		return "redirect:/cars/show";
	}
    
    
    @RequestMapping(value="/remove/car/{id}",method = RequestMethod.GET)
  	public String removeCarNormal(@PathVariable("id")Long id) throws Exception{
		Car car = carService.findById(id);
      	carService.delete(car);
  		return "redirect:/cars/show";
  	}
      
      
          
  		
	
	// TODO zle dziala location chce cala sciezke lacznie z serverem
	@RequestMapping(method = RequestMethod.GET, value = "/uri/{id}/{name}")
	public @ResponseBody
	String getUri(@PathVariable("id") Long id, @PathVariable("name") String name) {
		String result = UriComponentsBuilder.fromPath("/car/{id}/").build().expand(id).encode().toString();
	
		String ut = new UriTemplate(Car.class.getSimpleName()).expand(id).getPath();
		log.info(ut);
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/")
	public ResponseEntity<Void> createCar(@RequestBody Car car) throws Exception {
		carService.persist(car);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(linkTo(CarController.class).slash(car.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/simpleNew")
	public ResponseEntity<Car> createSimple(@RequestBody Car car) throws Exception {
		log.info("######################################   " + car);
	    carService.persist(car);
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(linkTo(CarController.class).slash(car.getId()).toUri());
		ResponseEntity<Car> res = new ResponseEntity<>(car, headers, HttpStatus.OK);
		return res;

	}

	@RequestMapping(method = RequestMethod.GET, value = "createTest")
	public ResponseEntity<Car> testCreateSimple() {
		ResponseEntity<Car> result = null;
		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		Car car = new Car();
		car.setAge(5);
		car.setName("ferrari");
		car.setPrice(new BigDecimal("3400"));
		HttpEntity<Car> entity = new HttpEntity<>(car, headers);
		result = restTemplate.exchange("http://localhost:8080/cars/simpleNew", HttpMethod.POST, entity, Car.class);
		log.info("+++				      {}  " , result);
		return result;
	}

	@RequestMapping("/handle")
	public @ResponseBody
	String handle() throws  IOException {
		@SuppressWarnings("resource")
		String text = new Scanner(xmlExample.getFile()).useDelimiter("\\A").next();
		log.info("TEXT BY SCANNER : {} " , text);
		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<String> entity = new HttpEntity<>(text, headers);
		ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/xmlPostReceiver", HttpMethod.POST, entity, String.class);
		if (result.getBody() == null) {
			return result.getStatusCode().toString();
		}
		return result.getBody();
	}

	@SuppressWarnings("boxing")
	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE })
	public ResponseEntity<Car> showCar(@PathVariable Long id) {
		return new ResponseEntity<>(carService.findById(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{carId}")
	public ResponseEntity<Void> destroyCar(@PathVariable Long carId) throws Exception {
		@SuppressWarnings("boxing")
		Car car = carService.findById(carId);
		carService.delete(car);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/page")
	public @ResponseBody
	Page<Car> cars(Pageable pageable) {
		return carService.findAllByPage(pageable);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddPage(Model model) {
		log.debug("Received request to show add page");
		model.addAttribute("car", new Car());
		return ADD_CAR_VIEW;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	Car addCar(@ModelAttribute(CAR_OBJECT) Car car, BindingResult result) throws Exception {
		log.debug("Add new car");

		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		carService.persist(car);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<Car> entity = new HttpEntity<>(car, headers);
		ResponseEntity<Car> res = null;
		try {
			res = restTemplate.exchange("http://localhost:8080/mvc-basic/cars/{id}", HttpMethod.GET, entity, Car.class, car.getId());
		} catch (Exception e) {
			log.error("{}", e);
		}
		if (res != null && res.getBody() != null) {
			return res.getBody();
		}
		return car;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getUpdatePage(@RequestParam(value = "id", required = true) Integer id, Model model) {
		log.debug("Received request to show edit page");
		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<Car> entity = new HttpEntity<>(headers);
		ResponseEntity<Car> result;
		try {
			result = restTemplate.exchange("http://localhost:8080/mvc-basic/cars/{id}", HttpMethod.GET, entity, Car.class, id);
			model.addAttribute("personAttribute", result.getBody());
		} catch (Exception e) {
			log.error("{}", e);
		}

		return ADD_CAR_VIEW;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute(CAR_OBJECT) Car car, @RequestParam(value = "id", required = true) Long id, Model model) {
		log.debug("Update existing car");
		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		// Pass the new person and header
		HttpEntity<Car> entity = new HttpEntity<>(car, headers);
		@SuppressWarnings("unused")
		ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/mvc-basic/cars/{id}", HttpMethod.PUT, entity, String.class, id);
		return ADD_CAR_VIEW;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody
	String deletePerson(@RequestParam("id") Long id, Model model) {
		log.debug("Delete existing car");
		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/mvc-basic/cars/{id}", HttpMethod.DELETE, entity, String.class, id);
		return result.getBody();
	}
	
	
}
