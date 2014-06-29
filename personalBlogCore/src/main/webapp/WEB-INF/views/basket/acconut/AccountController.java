package org.java.controller.acconut;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Sławomir Borowiec 
 * Module name : exampleSpring
 * Creating time :  19-08-2013 21:23:56
   // @Loggable  private Logger logger;
 */
@Controller
@RequestMapping(value = "/account")
@Slf4j
public class AccountController {
	public static final String VIEW_REDIRECT_PREFIX = "redirect:";

	
	private Map<Long, Account> accounts = new ConcurrentHashMap<>();

	private Set<String> words = new java.util.HashSet<>(4);

	@RequestMapping(method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new Account());

		words.add("slawek");
		words.add("piotr");
		words.add("maciek");
		words.add("adam");
		model.addAttribute(words);
		model.addAttribute("words", words);

		log.trace("/account -> invoke");
		return "account/createForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Account account, BindingResult result) {
		if (result.hasErrors()) {
			log.warn("Error during validate result {}", result.toString());
			return "account/createForm";
		}
		this.accounts.put(account.assignId(), account);
		log.info("post action sucess invoke {}", account);
		return createRedirectViewPath("/account/", account.getId().toString());
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		log.info("get view by id : {}", id);
		Account account = this.accounts.get(id);
		if (account == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(account);
		return "account/view";
	}

	public String createRedirectViewPath(String path, String params) {
		StringBuilder builder = new StringBuilder();
		builder.append(VIEW_REDIRECT_PREFIX);
		builder.append(path);
		if (StringUtils.hasText(params)) {
			builder.append(params);
		}
		return builder.toString();
	}
}
