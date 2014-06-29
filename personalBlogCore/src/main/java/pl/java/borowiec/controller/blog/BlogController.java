package pl.java.borowiec.controller.blog;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.java.borowiec.blog.Blog;
import pl.java.borowiec.service.blog.BlogService;
import pl.java.borowiec.view.BlogAtomView;
import pl.java.borowiec.view.BlogRssView;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 30-03-2013 14:36:35
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
	static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/atomfeed")
	public ModelAndView getAtomFeed(Model model) {
		List<Blog> blogs = blogService.getAllBlog();
		model.addAttribute("blogs", blogs);
		return new ModelAndView(new BlogAtomView(), model.asMap());
	}

	@RequestMapping("/rssfeed")
	public ModelAndView getRSSFeed(Model model) {
		List<Blog> blogs = blogService.getAllBlog();
		model.addAttribute("blogs", blogs);
		return new ModelAndView(new BlogRssView(), model.asMap());
	}
	
}
