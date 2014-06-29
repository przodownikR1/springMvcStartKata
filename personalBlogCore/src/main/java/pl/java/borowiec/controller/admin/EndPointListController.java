package pl.java.borowiec.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 11-04-2013 23:08:28
 */
@Controller
public class EndPointListController {
	private final static String VIEW_NAME = "admin/endpoint";
	private RequestMappingHandlerMapping handlerMapping;

	
	
	public EndPointListController() {
		super();
	}

	@Autowired
	public EndPointListController(RequestMappingHandlerMapping handlerMapping) {
		this.handlerMapping = handlerMapping;
	}

	@RequestMapping(value = "/endpointdoc", method = RequestMethod.GET)
	public String show(Model model) {
		model.addAttribute("handlerMethods", this.handlerMapping.getHandlerMethods());
		return VIEW_NAME;

	}
}
