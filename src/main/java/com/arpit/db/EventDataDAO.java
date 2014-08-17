package com.arpit.db;

public abstract class EventDataDAO<T> extends BaseDAO<T> {

	public EventDataDAO(Class<T> type) {
		super(type);
	}

}
