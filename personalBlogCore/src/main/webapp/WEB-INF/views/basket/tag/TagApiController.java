package org.java.controller.tag;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.java.domain.tag.Tag;
import org.java.exception.rest.ResourceNotFoundException;
import org.java.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@Slf4j
@RequestMapping(value="/api/tags")
public class TagApiController {

	@Autowired
	private TagService tagService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	Page<Tag> listTags(@MatrixVariable(required = true, defaultValue = "15", value = "resultsPerPage") int resultsPerPage,
			@MatrixVariable(required = true, defaultValue = "0", value = "pageNumber") int pageNumber) {
		log.info("listTag matrix  : resultPerPage {}  :  pageNumber  {} ", resultsPerPage, pageNumber);
		return tagService.findAll(new PageRequest(pageNumber, resultsPerPage));

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Tag getTag(@PathVariable Long id, Locale locale) throws ResourceNotFoundException  {
		log.info("Find Tag by id -  REST API : {}  , user {}  ", id );
		// final Tag loadedTag = Preconditions.checkNotNull(tagService.findById(id),id);
		return tagService.findById(id,locale);
	}
	
	
	@SuppressWarnings("boxing")
	@RequestMapping(value = "/test/{test}", method = RequestMethod.GET)
	public @ResponseBody
	Tag test(@PathVariable String test, @MatrixVariable Map<String, String> matrixVars ,Locale locale) throws ResourceNotFoundException {
		log.info("Find Tag by id -  REST API : {}  , user {}  ", matrixVars);
		return tagService.findById(1l,locale);
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateTagByID(@PathVariable("id") Long id, @Valid Tag tag, Locale locale) throws ResourceNotFoundException {
		log.info("Update Tag use id  {} : REST API : {}", id, tag);
		final Tag loadedTag = tagService.findById(id, locale);
		tagService.saveTagAfterLoadedResourceCheck(tag, loadedTag, locale);
	}

	@RequestMapping(value = "/name/{name}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateTagByName(@PathVariable String name, @RequestBody Tag tag, Locale locale) throws ResourceNotFoundException {
		log.info("Update Tag use name {} : REST API : {}", name, tag);
		final Tag loadedTag = tagService.findByUniqueName(name,locale);
		tagService.saveTagAfterLoadedResourceCheck(tag,loadedTag,locale);
	}

	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	// headers = { "Accept=text/xml, application/json" }
	public @ResponseBody
	Page<Tag> getTagByName(@PathVariable String name, Pageable pageable, Locale locale) {
		log.info("Get tags by name : {} and pageable : {} ", name, pageable);
		return tagService.findByName(name, pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTag(@PathVariable Long id, Locale locale) throws ResourceNotFoundException {
		log.info("Delete Tag use id  {} : REST API : {}", id);
		tagService.delete(id,locale);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> createTag(@Valid @RequestBody Tag tag, Locale locale) throws URISyntaxException {
		// TODO get location
		HttpHeaders headers = new HttpHeaders();
		tag.setId(null);
		Tag createdTag = tagService.saveTag(tag);
		String location = ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(createdTag.getId()).toUriString();
		headers.setLocation(new URI(location));
		log.info("Create new Tag  : {} and  :  location {}  ", tag, location);
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

}
