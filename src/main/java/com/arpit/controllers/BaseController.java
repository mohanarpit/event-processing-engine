package com.arpit.controllers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import reactor.core.Reactor;

public class BaseController  implements BeanFactoryAware{
	@Autowired
	protected Reactor reactor;

	@Autowired
	protected MongoOperations mongoOperation;
	
	@Override
	public void setBeanFactory(BeanFactory ctx) throws BeansException {
		mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	}
}
