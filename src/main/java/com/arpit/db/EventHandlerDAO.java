package com.arpit.db;


public abstract class EventHandlerDAO<T> extends BaseDAO<T> {

	public EventHandlerDAO(Class<T> type) {
		super(type);
	}

}
