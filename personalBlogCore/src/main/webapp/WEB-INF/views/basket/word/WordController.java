package org.java.controller.word;

import java.util.Locale;

import javax.validation.Valid;

import org.java.domain.dictionary.Word;
import org.java.service.word.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.java.risco.controllers.PaginationController;
import pl.java.risco.controllers.dto.MetaTableInfo;

@Controller
@RequestMapping(WordController.ACTION_URL)
public class WordController extends PaginationController<Word> {
	protected final static String ACTION_URL = "/word";
	private final static String VIEW_NAME = "word/wordView";
	private final static String EDIT_NAME = "word/wordEdit";
	private final static String CLASSIC_NAME = "word/classicView";
	private final static String PAGINATION_VIEW = "word/pagination";
	private static final String BEAN = "word";
	private static final int TABLE_HEIGTH = 500;
	private static final int TABLE_ROW_NUM = 20;
	private static final int TABLE_WIDTH = 700;
	private  WordService wordService;
	
	

	public WordController() {
		super();
	}

	@Autowired
	public WordController(WordService wordService) {
		super(wordService, PAGINATION_VIEW, BEAN);
		this.wordService = wordService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getWord(Model model) {
		Page<Word> words = wordService.findAllByPage(new PageRequest(0, 20,new Sort(Direction.ASC, "name")));
		model.addAttribute("words", words);
		return VIEW_NAME;
	}

	@RequestMapping(value = "/classic", method = RequestMethod.GET)
	public String classicView(Model model) {
		Page<Word> words = wordService.findAllByPage(new PageRequest(0, 20,new Sort(Direction.ASC, "name")));
		model.addAttribute("words", words);
		return CLASSIC_NAME;
	}

	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String removeWord(@PathVariable("id") Long id) throws Exception {
		if (id != null) {
			@SuppressWarnings("boxing")
			Word word = wordService.findById(id);
			wordService.delete(word);
		}
		return "redirect:/word/";
	}

	@RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
	public String editWord(Model model, @PathVariable("name") String name) {
		Word word = wordService.findByName(name);
		model.addAttribute(word);
		return EDIT_NAME;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editWord(Model model, @PathVariable("id") Long id) {
		if (id != null) {
			@SuppressWarnings("boxing")
			Word word = wordService.findById(id);
			if (word != null) {
				model.addAttribute(word);
			}
		} else
			model.addAttribute(new Word());

		return EDIT_NAME;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String editWordPost(@Valid  @ModelAttribute("word") Word word, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return EDIT_NAME;
		}
		wordService.persist(word);
		return "redirect:/word/";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		model.addAttribute(new Word());
		return EDIT_NAME;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUserPost(@ModelAttribute("word") Word word, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return EDIT_NAME;
		}
		wordService.persist(word);
		return "redirect:/word";
	}

	@Override
	public String getSortName() {
		return "name";
	}

	@Override
	public String getInheritUrl() {
		return ACTION_URL;
	}

	@Override
	public Class<Word> getDomainObject() {
		return Word.class;
	}

	@Override
	public MetaTableInfo getMetaTableInfo(Locale locale) {
		MetaTableInfo metaTableInfo = new MetaTableInfo(messageSource.getMessage("word.caption", null, locale), getInheritUrl());
		metaTableInfo.setHeight(TABLE_HEIGTH);
		metaTableInfo.setRowNum(TABLE_ROW_NUM);
		metaTableInfo.setWidth(TABLE_WIDTH);
		return metaTableInfo;
	}

}
