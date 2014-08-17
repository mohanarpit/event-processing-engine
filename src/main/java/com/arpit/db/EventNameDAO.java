package com.arpit.db;


public abstract class EventNameDAO<T> extends BaseDAO<T> {

	public EventNameDAO(Class<T> type) {
		super(type);
	}
}
