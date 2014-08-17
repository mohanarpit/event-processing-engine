package com.arpit.db;

public class EventDataManager extends EventDataDAO<EventDataEntity> {
	public EventDataManager() {
		super(EventDataEntity.class);
	}
}
