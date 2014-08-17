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
	public EventHandlerEntity getHandlerId() {
		return handler;
	}
	public void setHandlerId(EventHandlerEntity handlerId) {
		this.handler = handlerId;
	}
	public EventNameEntity getEventId() {
		return event;
	}
	public void setEventId(EventNameEntity eventId) {
		this.event = eventId;
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
	
	public EventRegistryEntity(EventHandlerEntity handlerId, EventNameEntity eventId,
			List<EventNamespace> namespaces) {
		super();
		this.handler = handlerId;
		this.event = eventId;
		this.namespaces = namespaces;
	}
	
	public EventRegistryEntity() {
		super();
	}
}
