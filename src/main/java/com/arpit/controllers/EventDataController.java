package com.arpit.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.event.Event;

import com.arpit.datatypes.EventDataType;

@RequestMapping("/data")
@RestController
public class EventDataController extends BaseController {

	@RequestMapping(value="/push", method=RequestMethod.POST)
	public @ResponseBody String push(@RequestBody @Valid final EventDataType event) {
		String eventName = event.getName();
		
		System.out.println("The name is: "+eventName);
		System.out.println(reactor.getDispatcher().toString());
		reactor.notify(eventName,Event.wrap(event));
		return eventName;
	}
}
