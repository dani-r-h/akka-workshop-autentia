package com.autentia.workshop.akka.exercise3;

public class ItalianoGreeterActor extends AbstractGreeterActor {

	public ItalianoGreeterActor(final EventBus eventBus) {
		super(eventBus);
	}

	@Override
	public String getGreeting(Object event) {
		return "Ciao "+event;
	}
	
}
