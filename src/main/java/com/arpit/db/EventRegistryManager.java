package com.arpit.db;

public class EventRegistryManager extends EventRegistryDAO<EventRegistryEntity> {
	public EventRegistryManager() {
		super(EventRegistryEntity.class);
	}
}