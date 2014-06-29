package org.java.controller.ajax;

public class Topic {

	private String name;

	private String technologies;

	public Topic() {}

	public Topic(String name, String technologies) {
		this.name = name;
		this.technologies = technologies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

}