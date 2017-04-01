package com.autentia.workshop.akka.exercise3;

public class EnglishGreeterActor extends AbstractGreeterActor{

	public EnglishGreeterActor(EventBus eventBus) {
		super(eventBus);
	}

	@Override
	public String getGreeting(Object event) {
		return "Hello "+event;
	}

}
