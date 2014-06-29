package pl.java.borowiec.controller.admin.reports;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import pl.java.borowiec.view.ExcelTestView;



/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  13-04-2013 17:21:07
 
 */
@Controller
@RequestMapping(value = "/generateReport")
public class GenerateController {

	@RequestMapping("/test_xls")
	public ModelAndView getResult(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// System.err.println(messageSource.getMessage("user", null, Locale.getDefault()));
		List<String> header = new LinkedList<String>();
		header.add("slawek");
		header.add("pawel");
		header.add("yamaha");
		List<List<Object>> row = new LinkedList<List<Object>>();
		List<Object> o1 = new ArrayList<Object>();
		o1.add(new Date());
		o1.add(new Double(23));
		o1.add("asdasd");
		row.add(o1);
		View view = new ExcelTestView();
		model.addAttribute("headerNames", header);
		model.addAttribute("rows", row);
		view.render(model.asMap(), request, response);
		return new ModelAndView(view);
	}

	
}
