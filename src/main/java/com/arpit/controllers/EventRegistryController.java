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
	public @ResponseBody String insert(@RequestBody @Valid final EventRegistryEntity ehe) {
		BaseDAO<EventRegistryEntity> dao = new EventRegistryManager();
		dao.setMongoOperation(mongoOperation);
		dao.add(ehe);
		return "true";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody List<EventRegistryEntity> get(@PathVariable("id") String id) {
		BaseDAO<EventRegistryEntity> dao = new EventRegistryManager();
		dao.setMongoOperation(mongoOperation);
		return dao.get(id);
	}
}
