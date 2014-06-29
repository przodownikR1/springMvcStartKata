package pl.java.borowiec.controller.comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 30-03-2013 14:36:04
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
	static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);
}
