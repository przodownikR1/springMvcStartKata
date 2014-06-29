package org.java.controller.ajax.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/personAjax")
public class PersonController {
 private final static String PERSON_VIEW = "/ajax/person";
 private final static String PERSON_LIST_VIEW = "/ajax/personList";
 
 private List<PersonDTO> store = new ArrayList<>();
 
 @RequestMapping("/")
 public String get(Model model){
	 model.addAttribute("persons", store);
	 return PERSON_VIEW;
 }
 
 @RequestMapping(value="/",method=RequestMethod.POST)
 public @ResponseBody String addUser(@ModelAttribute(value="user") PersonDTO user, BindingResult result ){
     String returnText;
     if(!result.hasErrors()){
         store.add(user);
         returnText = "User has been added to the list. Total number of users are " + store.size();
     }else{
         returnText = "Sorry, an error has occur. User has not been added to list.";
     }
     return returnText;
 }

 @RequestMapping("/show")
 public String show(Model model){
	 model.addAttribute("persons", store);
	 return PERSON_LIST_VIEW;
 }

 
}
