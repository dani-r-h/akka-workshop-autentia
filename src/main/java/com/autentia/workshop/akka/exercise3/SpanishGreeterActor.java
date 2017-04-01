package com.autentia.workshop.akka.exercise3;

public class SpanishGreeterActor extends AbstractGreeterActor{

	public SpanishGreeterActor(EventBus eventBus) {
		super(eventBus);
	}

	@Override
	public String getGreeting(Object event) {
		return "Hola "+event;
	}

}
