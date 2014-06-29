package pl.java.borowiec.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import pl.java.borowiec.blog.Blog;

import com.sun.syndication.feed.atom.Content;
import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.feed.atom.Feed;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 11-04-2013 23:46:25
 */
public class BlogAtomView extends AbstractAtomFeedView {
	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Feed feed, HttpServletRequest request) {
		super.buildFeedMetadata(model, feed, request);
		feed.setId("tag:personalBlog");
		feed.setTitle("My blog ");
		List<Blog> blogs = (List<Blog>) model.get("blogs");
		for (Blog blog : blogs) {
			Date date = blog.getDateAdded();
			if (feed.getUpdated() == null || date.compareTo(feed.getUpdated()) > 0) {
				feed.setUpdated(date);
			}
		}

	}

	@Override
	protected List<Entry> buildFeedEntries(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Blog> blogs = (List<Blog>) model.get("blogs");
		List<Entry> entries = new ArrayList<Entry>(blogs.size());
		for (Blog blog : blogs) {
			Entry entry = new Entry();
			String date = String.format("%1$tY-%1$tm-%1$td", blog.getDateAdded());
			entry.setId(String.format("tag:car.name,%s:%d", date, blog.getId()));
			entry.setTitle(String.format("Car name %s", blog.getName()));
			entry.setUpdated(blog.getDateModyfication());
			Content summary = new Content();
			summary.setValue(String.format("%s - %s", "summary", "value"));
			entry.setSummary(summary);
			entries.add(entry);
		}
		return entries;
	}
}
