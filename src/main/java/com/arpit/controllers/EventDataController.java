package com.arpit.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/data")
@RestController
public class EventDataController {

	@RequestMapping(value="/push", method=RequestMethod.POST)
	public String index() {
		return "true";
	}
}
