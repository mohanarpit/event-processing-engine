package com.arpit.datatypes;

import java.util.List;

import javax.validation.constraints.NotNull;

public class EventDataType {
	
	/**
	 * The name of the event. Must be unique.
	 */
	@NotNull
	private String name;
	/**
	 * This is the json string with the data in it.
	 */
	@NotNull
	private String data;
	private String type;
	
	private List<EventNamespace> eventNamespaces;
	private String source;
	
	public EventDataType() {}
	
	public EventDataType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EventNamespace> getEventNamespaces() {
		return eventNamespaces;
	}

	public void setEventNamespaces(List<EventNamespace> eventNamespaces) {
		this.eventNamespaces = eventNamespaces;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
}
