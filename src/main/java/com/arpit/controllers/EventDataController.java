package com.arpit.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.event.Event;

import com.arpit.datatypes.EventDataType;
import com.arpit.db.BaseDAO;
import com.arpit.db.EventDataEntity;
import com.arpit.db.EventDataManager;

@RequestMapping("/data")
@RestController
public class EventDataController extends BaseController {

	@RequestMapping(value="/push", method=RequestMethod.POST)
	public @ResponseBody String push(@RequestBody @Valid final EventDataType event) {
		String eventName = event.getName();
		System.out.println("The name is: "+eventName);
		System.out.println(reactor.getDispatcher().toString());
		
		//Persist the data in the event table first so that there is no loss of data
		BaseDAO<EventDataEntity> dao = new EventDataManager();
		dao.setMongoOperation(mongoOperation);
		EventDataEntity entity = new EventDataEntity(); 
		entity.setData(event.getData());
		entity.setNamespaces(event.getEventNamespaces());
		entity.setStatus("Pending");
		entity.setSource(event.getSource());
		dao.add(entity);
		
		reactor.notify(eventName,Event.wrap(event));
		return eventName;
	}
}
