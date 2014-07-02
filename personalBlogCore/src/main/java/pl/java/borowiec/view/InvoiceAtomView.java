package pl.java.borowiec.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import pl.java.borowiec.simple.Invoice;

import com.sun.syndication.feed.atom.Content;
import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.feed.atom.Feed;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 11-04-2013 23:46:25
 */
public class InvoiceAtomView extends AbstractAtomFeedView {
	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Feed feed, HttpServletRequest request) {
		super.buildFeedMetadata(model, feed, request);
		feed.setId("tag:invocie");
		feed.setTitle("My invoice");
		@SuppressWarnings("unchecked")
        List<Invoice> invoices = (List<Invoice>) model.get("invoices");
		for (Invoice invoice : invoices) {
			Date date = invoice.getCreataDate();
			if (feed.getUpdated() == null || date.compareTo(feed.getUpdated()) > 0) {
				feed.setUpdated(date);
			}
		}

	}

	@Override
	protected List<Entry> buildFeedEntries(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
        List<Invoice> invoices = (List<Invoice>) model.get("invoices");
		List<Entry> entries = new ArrayList<>(invoices.size());
		for (Invoice invoice : invoices) {
			Entry entry = new Entry();
			String date = String.format("%1$tY-%1$tm-%1$td", invoice.getCreataDate());
			entry.setId(String.format("tag:invoice.id,%s:%d", date, invoice.getId()));
			entry.setTitle(String.format("Incoice name %s", invoice.getName()));
			entry.setUpdated(invoice.getPayDate());
			Content summary = new Content();
			summary.setValue(String.format("%s - %s", "summary", "value"));
			entry.setSummary(summary);
			entries.add(entry);
		}
		return entries;
	}
}
