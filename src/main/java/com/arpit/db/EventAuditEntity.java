package com.arpit.db;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="event_audit")
public class EventAuditEntity {

	@Id
	private String id;
	
	private String status;
	private BigInteger eventId;
	private List<BigInteger> handlers;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigInteger getEventId() {
		return eventId;
	}
	public void setEventId(BigInteger eventId) {
		this.eventId = eventId;
	}
	public List<BigInteger> getHandlers() {
		return handlers;
	}
	public void setHandlers(List<BigInteger> handlers) {
		this.handlers = handlers;
	}
	@Override
	public String toString() {
		return "EventAuditEntity [id=" + id + ", status=" + status
				+ ", eventId=" + eventId + ", handlers=" + handlers + "]";
	}
	public EventAuditEntity(String status, BigInteger eventId,
			List<BigInteger> handlers) {
		super();
		this.status = status;
		this.eventId = eventId;
		this.handlers = handlers;
	}
	
	public EventAuditEntity() {
		super();
	}
}
