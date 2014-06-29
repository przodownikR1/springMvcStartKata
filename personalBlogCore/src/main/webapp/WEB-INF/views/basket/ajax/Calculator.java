package org.java.controller.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.domain.car.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 13:57:11
 */
@Controller
@RequestMapping("/ajax")
public class Calculator {
	private final static String VIEW_NAME = "ajax/ajaxView";

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAjaxAddPage() {
		return VIEW_NAME;
	}

	@SuppressWarnings("boxing")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	Integer add(@RequestParam(value = "inputNumber1", required = true) Integer inputNumber1,
			@RequestParam(value = "inputNumber2", required = true) Integer inputNumber2, HttpServletRequest req, HttpServletResponse res, Model model) {
		return inputNumber1 + inputNumber2;
	}

	@RequestMapping(value = "/json")
	public @ResponseBody
	Car jsonGet() {
		Car car = new Car();
		car.setAge(1);
		car.setName("star");
		return car;

	}
}
