package com.arpit.controllers;

import static reactor.event.selector.Selectors.$;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import reactor.core.Reactor;
import reactor.event.Event;
import reactor.function.Consumer;

import com.arpit.datatypes.EventDataType;
import com.arpit.db.BaseDAO;
import com.arpit.db.EventNameEntity;
import com.arpit.db.EventRegistryEntity;
import com.arpit.db.EventRegistryManager;

@Component
public class ApplicationInitOnStartup implements ApplicationListener<ContextRefreshedEvent>, BeanFactoryAware {

	@Autowired
	Reactor reactor;

	@Autowired
	protected MongoOperations mongoOperation;
	
	@SuppressWarnings("unchecked")
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		System.out.println("********The application is refreshed********");
		BaseDAO<EventRegistryEntity> dao = new EventRegistryManager();
		dao.setMongoOperation(mongoOperation);
		List<EventRegistryEntity> eventRegistries = dao.getAll();
		for(EventRegistryEntity eventRegistry: eventRegistries) {
			System.out.println("Setting reactor subscriber for "+ eventRegistry.getId());
			EventNameEntity eventName = new EventNameEntity();
			eventName = eventRegistry.getEvent();
			String eventHandlerName = eventRegistry.getHandler().getImpl();
			Consumer<Event<EventDataType>> eventHandler = null;
			try {
				eventHandler = (Consumer<Event<EventDataType>>) Class.forName(eventHandlerName).newInstance();
				reactor.on($(eventName.getName()), eventHandler);
			} catch (InstantiationException 
					| IllegalAccessException
					| ClassNotFoundException e) {
				System.out.println("Unable to register handler "+eventHandlerName+ " with reactor");
			}
		}
	}

	@Override
	public void setBeanFactory(BeanFactory ctx) throws BeansException {
		mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	}

}
