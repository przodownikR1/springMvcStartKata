package pl.java.borowiec.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.java.borowiec.jmx.Info;
import pl.java.borowiec.jmx.PerformanceMonitor;


/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  14-04-2013 00:17:44
 
 */
@Controller
@RequestMapping("/performance")
public class PerformanceWebController {
	
	private final static String VIEW_NAME = "admin/performanceMonitorView";
    @Autowired(required=false)
	private PerformanceMonitor performanceMonitor;
    
	
	
	@RequestMapping(value = "/monitor", method = RequestMethod.GET)
	public String monitorTest(Model model, HttpServletRequest request, HttpServletResponse response) {
		Map<String,Info> result = performanceMonitor.getMap();
		model.addAttribute("result", result);
		return VIEW_NAME;
    
	}
	
	
}
