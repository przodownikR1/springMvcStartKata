package pl.java.borowiec.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 30-03-2013 14:34:46
 */
@Controller
@RequestMapping("/user")
public class UserController {
	static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
}
