package org.java.controller.tag;

import java.util.List;

import javax.validation.Valid;

import org.java.domain.tag.Tag;
import org.java.exception.rest.ResourceNotFoundException;
import org.java.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
@Controller
@RequestMapping("/tags")
public class TagController {
	private final static String VIEW = "tag/tags";
	private final static String EDIT_VIEW = "tag/tag";

	@Autowired
	private TagService tagService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listTag(ModelMap modelMap) {
		List<Tag> tags = tagService.findAll();
		modelMap.put("tags", tags);
		return VIEW;
	}

	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public String findByName(@PathVariable String name, ModelMap modelMap) {
		List<Tag> tags = tagService.findByName(name, new PageRequest(0, 20)).getContent();
		modelMap.put("tags", tags);
		return EDIT_VIEW;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable("id") Long id, Model model) throws ResourceNotFoundException {
		Tag found = tagService.findById(id);
		model.addAttribute("tag", found);
		return EDIT_VIEW;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String editTag(@Valid  @ModelAttribute("tag") Tag tag, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return EDIT_VIEW;
		}
		tagService.saveTag(tag);
		return "redirect:/tags/";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addTag(Model model) {
		model.addAttribute(new Tag());
		return EDIT_VIEW;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createTag(@ModelAttribute("tag") Tag tag, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return EDIT_VIEW;
		}
		tagService.saveTag(tag);
		return "redirect:/tags/";
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String removeTag(@PathVariable("id") Long id) throws IllegalArgumentException,ResourceNotFoundException {
		if (id != null) {
			tagService.delete(id);
		}
		return "redirect:/tags/";
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTagNotFoundException(ResourceNotFoundException ex) {
    }
	
}
