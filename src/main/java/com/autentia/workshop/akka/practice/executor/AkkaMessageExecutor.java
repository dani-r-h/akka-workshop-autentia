package com.autentia.workshop.akka.practice.executor;

import com.autentia.workshop.akka.practice.model.Event;

import akka.actor.ActorSystem;

public class AkkaMessageExecutor extends AbstractMessageExecutor implements MessageExecutor{
	
	public AkkaMessageExecutor(final ActorSystem actorSystem) {
		super(actorSystem);
		
		//TODO Initialization actors
	}

	public void execute(Event event) {
		//TODO Write some logic with actors
		
		throw new UnsupportedOperationException();		
	}

}
