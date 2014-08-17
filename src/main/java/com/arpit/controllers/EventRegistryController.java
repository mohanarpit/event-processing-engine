package com.arpit.controllers;

import static reactor.event.selector.Selectors.$;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.actors.Receiver;
import com.arpit.datatypes.EventRegistryDataType;
import com.arpit.db.BaseDAO;
import com.arpit.db.EventHandlerEntity;
import com.arpit.db.EventHandlerManager;
import com.arpit.db.EventNameEntity;
import com.arpit.db.EventNameManager;
import com.arpit.db.EventRegistryEntity;
import com.arpit.db.EventRegistryManager;

@RestController
@RequestMapping(value="/eventregistry")
public class EventRegistryController extends BaseController{
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<EventRegistryEntity> index() {
		BaseDAO<EventRegistryEntity> dao = new EventRegistryManager();
		dao.setMongoOperation(mongoOperation);
		return dao.getAll();
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public @ResponseBody String insert(@RequestBody @Valid final EventRegistryDataType eventRegistry) {
		if(eventRegistry == null)
			return "false";
		if(eventRegistry.getHandlerId() == null || eventRegistry.getEventId() == null)
			return "false";
		BaseDAO<EventNameEntity> eventDao = new EventNameManager();
		eventDao.setMongoOperation(mongoOperation);
		EventNameEntity eventEntity = eventDao.get(eventRegistry.getEventId());
		
		if(eventEntity == null)
			return "No event found by that ID";
		
		BaseDAO<EventHandlerEntity> handlerDao = new EventHandlerManager();
		handlerDao.setMongoOperation(mongoOperation);
		EventHandlerEntity handlerEntity = handlerDao.get(eventRegistry.getHandlerId());
		
		if(handlerEntity == null)
			return "No handler found by that ID";
		
		EventRegistryEntity registryEntity = new EventRegistryEntity();
		registryEntity.setEvent(eventEntity);
		registryEntity.setHandler(handlerEntity);
		registryEntity.setNamespaces(eventRegistry.getNamespaces());
		
		BaseDAO<EventRegistryEntity> dao = new EventRegistryManager();
		dao.setMongoOperation(mongoOperation);
		dao.add(registryEntity);
		reactor.on($(eventEntity.getName()), new Receiver());
		return registryEntity.getId();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody EventRegistryEntity get(@PathVariable("id") String id) {
		BaseDAO<EventRegistryEntity> dao = new EventRegistryManager();
		dao.setMongoOperation(mongoOperation);
		return dao.get(id);
	}
}
