package org.java.controller.ajax.simple;

import lombok.extern.slf4j.Slf4j;

import org.java.domain.dictionary.Word;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class WordAjaxController {
    private static final String VIEW_NAME="word/wordAjax";
	@RequestMapping(value = "/wordAjax", method = RequestMethod.GET)
	public String word(Model model ) {
		Word word = new Word();
		word.setName("good morning");
		word.setTranslate("dzien dobry");
		log.info(" word    {}",word);
		return VIEW_NAME;
	}
	
	@RequestMapping(value = "/wordAjax", method = RequestMethod.POST)
	public @ResponseBody
	Word getRequest(@RequestBody Word word) {
		log.info(" word    {}",word);
		return word;
	}
}
