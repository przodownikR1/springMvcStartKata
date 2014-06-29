package org.java.controller.ajax;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  13-04-2013 13:36:33
 
 */
@Controller
@RequestMapping("/autocomplete")
public class AutoCompleteController {
	private static TopicDB dummyDB = new TopicDB();
    private final static String VIEW_NAME = "ajax/autocomplete";
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		Topic topic = new Topic();
		model.addAttribute("topic", topic);
		return VIEW_NAME;
	}



	@RequestMapping(value = "/get_tech_list", method = RequestMethod.GET, headers="Accept=*/*",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> getTechList(@RequestParam("term") String query) {
		return dummyDB.getTechList(query);
	}
}
