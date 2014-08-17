package com.arpit.controllers;

import static reactor.event.selector.Selectors.$;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import reactor.core.Reactor;

import com.arpit.actors.Receiver;

@Component
public class ApplicationInitOnStartup implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	Reactor reactor;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		System.out.println("********The application is refreshed********");
		
		reactor.on($("name"), new Receiver());
	}

}
