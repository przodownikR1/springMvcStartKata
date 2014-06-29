package pl.java.borowiec.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/test")
	public @ResponseBody
	String getOk() {
		return "ok"; //$NON-NLS-1$
	}

}
