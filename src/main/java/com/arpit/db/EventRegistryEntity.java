package com.arpit.db;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.arpit.datatypes.EventNamespace;

@Document(collection="event_registry")
public class EventRegistryEntity {

	@Id
	private String id;
	
	@DBRef
	private EventHandlerEntity handler;
	@DBRef
	private EventNameEntity event;
	private List<EventNamespace> namespaces;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public EventHandlerEntity getHandler() {
		return handler;
	}
	public void setHandler(EventHandlerEntity handler) {
		this.handler = handler;
	}
	public EventNameEntity getEvent() {
		return event;
	}
	public void setEvent(EventNameEntity event) {
		this.event = event;
	}
	public List<EventNamespace> getNamespaces() {
		return namespaces;
	}
	public void setNamespaces(List<EventNamespace> namespaces) {
		this.namespaces = namespaces;
	}
	@Override
	public String toString() {
		return "EventRegistryEntity [id=" + id + ", handlerId=" + handler
				+ ", eventId=" + event + ", namespaces=" + namespaces + "]";
	}
	
	public EventRegistryEntity(EventHandlerEntity handler, EventNameEntity event,
			List<EventNamespace> namespaces) {
		super();
		this.handler = handler;
		this.event = event;
		this.namespaces = namespaces;
	}
	
	public EventRegistryEntity() {
		super();
	}
}
