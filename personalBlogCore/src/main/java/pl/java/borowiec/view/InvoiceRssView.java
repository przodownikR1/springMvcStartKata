package pl.java.borowiec.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import pl.java.borowiec.simple.Invoice;

import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Item;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 11-04-2013 23:49:05
 */
public class InvoiceRssView extends AbstractRssFeedView {
    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Channel feed, HttpServletRequest request) {
        super.buildFeedMetadata(model, feed, request);
        feed.setTitle("invoice title");
        feed.setDescription("invoice descpripion ");
        feed.setLink("invoice.org");

        @SuppressWarnings("unchecked")
        List<Invoice> invoices = (List<Invoice>) model.get("invoices");
        for (Invoice invoice : invoices) {
            Date date = new Date(invoice.getCreataDate().toEpochDay());
            if (feed.getLastBuildDate() == null || date.compareTo(feed.getLastBuildDate()) > 0) {
                feed.setLastBuildDate(date);
            }
        }

    }

    @Override
    protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("unchecked")
        List<Invoice> invoices = (List<Invoice>) model.get("invoices");
        List<Item> items = new ArrayList<>(invoices.size());
        for (Invoice invoice : invoices) {
            Item item = new Item();
            //item.setLink(link);
            item.setTitle(String.format("Blog name %s", invoice.getName()));
            item.setPubDate(new Date(invoice.getCreataDate().toEpochDay()));
           
            items.add(item);
        }
        return items;
    }

}
