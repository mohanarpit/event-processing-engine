package com.arpit.datatypes;

import java.util.List;

import javax.validation.constraints.NotNull;

public class EventRegistryDataType {
	@NotNull
	private String handlerId ;
	@NotNull
	private String eventId;
	
	private List<EventNamespace> namespaces;

	public String getHandlerId() {
		return handlerId;
	}

	public void setHandlerId(String handlerId) {
		this.handlerId = handlerId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public List<EventNamespace> getNamespaces() {
		return namespaces;
	}

	public void setNamespaces(List<EventNamespace> namespaces) {
		this.namespaces = namespaces;
	}
	
	
}
