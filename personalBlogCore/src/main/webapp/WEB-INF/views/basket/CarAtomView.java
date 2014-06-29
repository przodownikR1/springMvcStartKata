package pl.java.JCodeLeader.core.contollers.experimental.car.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;
import pl.java.JCodeLeader.experimental.rest.Car;
import com.sun.syndication.feed.atom.Content;
import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.feed.atom.Feed;

public  class CarAtomView extends AbstractAtomFeedView{
    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Feed feed, HttpServletRequest request) {
    	super.buildFeedMetadata(model, feed, request);
    	feed.setId("tag:przodownik.pracy");
    	feed.setTitle("trip test feed");
    	List<Car> cars = (List<Car>)model.get("cars");
    	for (Car car : cars) {
    	Date date = car.getDateAdded();
    	if (feed.getUpdated() == null || date.compareTo(feed.getUpdated()) > 0) {
    	feed.setUpdated(date);
    	}
    	}

    }
	@Override
	protected List<Entry> buildFeedEntries(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

			List<Car> cars =(List<Car>)model.get("cars");
			List<Entry> entries = new ArrayList<Entry>(cars.size());
			for (Car car: cars) {
			Entry entry = new Entry();
			String date = String.format("%1$tY-%1$tm-%1$td",car.getDateAdded());
			entry.setId(String.format("tag:car.name,%s:%d", date,car.getId()));
			entry.setTitle(String.format("Car name %s", car.getName()));
			entry.setUpdated(car.getDateModification());
			Content summary = new Content();
			summary.setValue(String.format("%s - %s","summary","value"));
			entry.setSummary(summary);
			entries.add(entry);
			}
			return entries;
	}
}
