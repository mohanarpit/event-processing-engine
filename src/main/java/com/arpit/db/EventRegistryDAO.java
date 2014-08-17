package com.arpit.db;

public abstract class EventRegistryDAO<T> extends BaseDAO<T> {

	public EventRegistryDAO(Class<T> type) {
		super(type);
	}
}
