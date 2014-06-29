package pl.java.borowiec.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import pl.java.borowiec.blog.Blog;

import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Item;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 11-04-2013 23:49:05
 */
public class BlogRssView extends AbstractRssFeedView {
	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed, HttpServletRequest request) {
		super.buildFeedMetadata(model, feed, request);
		feed.setTitle("blog test rss");
		feed.setDescription("blog descpripion ");
		feed.setLink("blog.org");

		List<Blog> Blogs = (List<Blog>) model.get("blogs");
		for (Blog Blog : Blogs) {
			Date date = Blog.getDateAdded();
			if (feed.getLastBuildDate() == null || date.compareTo(feed.getLastBuildDate()) > 0) {
				feed.setLastBuildDate(date);
			}
		}

	}

	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Blog> blogs = (List<Blog>) model.get("blogs");
		List<Item> items = new ArrayList<Item>(blogs.size());
		for (Blog blog : blogs) {
			Item item = new Item();
			String date = String.format("%1$tY-%1$tm-%1$td", blog.getDateAdded());

			item.setTitle(String.format("Blog name %s", blog.getName()));
			item.setPubDate(blog.getDateAdded());
			// item.setLink("localhost:9090/PersonalBlog/blog/"+Blog.getId());
			items.add(item);
		}
		return items;
	}

}
