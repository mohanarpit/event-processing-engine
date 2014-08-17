package com.arpit.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.event.Event;

import com.arpit.datatypes.EventDataType;
import com.arpit.datatypes.EventNamespace;
import com.arpit.db.BaseDAO;
import com.arpit.db.EventHandlerEntity;
import com.arpit.db.EventHandlerManager;

@RestController
@RequestMapping(value="/eventhandler")
public class EventHandlerController extends BaseController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<EventHandlerEntity> index() {
		BaseDAO<EventHandlerEntity> ehm = new EventHandlerManager();
		ehm.setMongoOperation(mongoOperation);
		return ehm.getAll();
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public @ResponseBody String insert(@RequestBody @Valid final EventHandlerEntity ehe) {
		BaseDAO<EventHandlerEntity> ehm = new EventHandlerManager();
		ehm.setMongoOperation(mongoOperation);
		ehm.add(ehe);
		return "true";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody List<EventHandlerEntity> get(@PathVariable("id") String id) {
		BaseDAO<EventHandlerEntity> ehm = new EventHandlerManager();
		ehm.setMongoOperation(mongoOperation);
		return ehm.get(id);
	}

	@RequestMapping(value="/push", method=RequestMethod.POST)
	public @ResponseBody String push(@RequestBody @Valid final EventDataType event) {
		String eventName = event.getName();
		List<EventNamespace> ens = event.getEventNamespaces();
		for(EventNamespace ns : ens ) {
			System.out.println(ns.getKey());
			System.out.println(ns.getValue());
		}
		
		System.out.println("The name is: "+eventName);
//		reactor.on($("name"), new Receiver());
		System.out.println(reactor.getDispatcher().toString());
//		reactor.on($("name"), new ReceiverDup());
		reactor.notify(eventName,Event.wrap(event));
		return eventName;
	}
}
