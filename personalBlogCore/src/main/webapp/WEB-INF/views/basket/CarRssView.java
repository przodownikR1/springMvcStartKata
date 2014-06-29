package pl.java.JCodeLeader.core.contollers.experimental.car.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;
import pl.java.JCodeLeader.experimental.rest.Car;

import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Item;

public class CarRssView extends AbstractRssFeedView {
	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Channel feed, HttpServletRequest request) {
		super.buildFeedMetadata(model, feed, request);
		feed.setTitle("trip test rss");
		feed.setDescription("test new spring functionality ");
		feed.setLink("tennis.org");

		List<Car> cars = (List<Car>) model.get("cars");
		for (Car car : cars) {
			Date date = car.getDateAdded();
			if (feed.getLastBuildDate() == null || date.compareTo(feed.getLastBuildDate()) > 0) {
				feed.setLastBuildDate(date);
			}
		}

	}

	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Car> cars = (List<Car>) model.get("cars");
		List<Item> items = new ArrayList<Item>(cars.size());
		for (Car car : cars) {
			Item item = new Item();
			String date = String.format("%1$tY-%1$tm-%1$td", car.getDateAdded());

			item.setTitle(String.format("Car name %s", car.getName()));
			item.setPubDate(car.getDateAdded());
			//item.setLink("localhost:9090/tripCore/car/"+car.getId());
			items.add(item);
		}
		return items;
	}

}
