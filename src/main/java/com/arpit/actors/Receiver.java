package com.arpit.actors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.Reactor;
import reactor.event.Event;
import reactor.function.Consumer;

import com.arpit.datatypes.EventDataType;

@Service
public class Receiver implements Consumer<Event<EventDataType>>{

	@Autowired
	Reactor reactor;
	
	@Override
	public void accept(Event<EventDataType> arg0) {
		System.out.println("In the receiverDup accept");
	}
}
