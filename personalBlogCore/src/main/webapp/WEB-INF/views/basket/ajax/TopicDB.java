package org.java.controller.ajax;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 13:32:33
 */
public class TopicDB {

	private List<String> tags;

	public TopicDB() {

		String strTags = "Hibernate, Spring, Struts , Spring Security, JSON , C# , HQL , Camel, Java, JQuery, CXF, MySQL, DSL";
		tags = new ArrayList<>();
		StringTokenizer st2 = new StringTokenizer(strTags, ",");

		while (st2.hasMoreTokens()) {
			tags.add(st2.nextToken().trim());
		}

	}

	public List<String> getTechList(String query) {
		String country = null;
		query = query.toLowerCase();
		List<String> matched = new ArrayList<>();
		for (int i = 0; i < tags.size(); i++) {
			country = tags.get(i).toLowerCase();
			if (country.startsWith(query)) {
				matched.add(tags.get(i));
			}
		}
		return matched;
	}
}