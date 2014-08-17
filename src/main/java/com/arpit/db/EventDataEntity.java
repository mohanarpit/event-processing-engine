package com.arpit.db;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.arpit.datatypes.EventNamespace;

@Document(collection="event_data")
public class EventDataEntity {

	@Id
	private String id;
	private String data;
	private List<EventNamespace> namespaces;
	private String source;
	private String status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<EventNamespace> getNamespaces() {
		return namespaces;
	}
	public void setNamespaces(List<EventNamespace> namespaces) {
		this.namespaces = namespaces;
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "EventDataEntity [id=" + id + ", data=" + data + ", namespaces="
				+ namespaces + ", source=" + source + ", status=" + status
				+ "]";
	}
	
	public EventDataEntity() {
		super();
	}
}
