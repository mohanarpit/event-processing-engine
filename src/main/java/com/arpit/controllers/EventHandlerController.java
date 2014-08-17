package com.arpit.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.db.BaseDAO;
import com.arpit.db.EventHandlerEntity;
import com.arpit.db.EventHandlerManager;

@RestController
@RequestMapping(value="/eventhandler")
public class EventHandlerController extends BaseController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<EventHandlerEntity> index() {
		BaseDAO<EventHandlerEntity> dao = new EventHandlerManager();
		dao.setMongoOperation(mongoOperation);
		return dao.getAll();
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public @ResponseBody String insert(@RequestBody @Valid final EventHandlerEntity ehe) {
		BaseDAO<EventHandlerEntity> dao = new EventHandlerManager();
		dao.setMongoOperation(mongoOperation);
		dao.add(ehe);
		return ehe.getId();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody EventHandlerEntity get(@PathVariable("id") String id) {
		BaseDAO<EventHandlerEntity> dao = new EventHandlerManager();
		dao.setMongoOperation(mongoOperation);
		return dao.get(id);
	}
}
