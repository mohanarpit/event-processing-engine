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
import com.arpit.db.EventNameEntity;
import com.arpit.db.EventNameManager;


@RestController
@RequestMapping(value="/eventname")
public class EventNameController extends BaseController{

	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<EventNameEntity> index() {
		BaseDAO<EventNameEntity> dao = new EventNameManager();
		dao.setMongoOperation(mongoOperation);
		return dao.getAll();
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public @ResponseBody String insert(@RequestBody @Valid final EventNameEntity ehe) {
		BaseDAO<EventNameEntity> dao = new EventNameManager();
		dao.setMongoOperation(mongoOperation);
		dao.add(ehe);
		return ehe.getId();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody EventNameEntity get(@PathVariable("id") String id) {
		BaseDAO<EventNameEntity> dao = new EventNameManager();
		dao.setMongoOperation(mongoOperation);
		return dao.get(id);
	}
}
