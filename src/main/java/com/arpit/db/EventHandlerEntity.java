package com.arpit.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="event_handlers")
public class EventHandlerEntity {
	@Id
	private String id;
	
	private String name;
	
	private String impl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImpl() {
		return impl;
	}

	public void setImpl(String impl) {
		this.impl = impl;
	}

	@Override
	public String toString() {
		return "EventHandlerEntity [id=" + id + ", name=" + name + ", impl="
				+ impl + "]";
	}

	public EventHandlerEntity() {
		super();
	}
}
