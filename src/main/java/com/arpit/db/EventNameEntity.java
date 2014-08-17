package com.arpit.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="event_names")
public class EventNameEntity {

	@Id
	private String id;
	private String name;
	private String type;
	private String desc;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "EventName [id=" + id + ", name=" + name + ", type=" + type
				+ ", desc=" + desc + "]";
	}
	public EventNameEntity(String name, String type, String desc) {
		super();
		this.name = name;
		this.type = type;
		this.desc = desc;
	}
	
	public EventNameEntity() {
		super();
	}
}
