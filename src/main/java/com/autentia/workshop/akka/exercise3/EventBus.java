package com.autentia.workshop.akka.exercise3;

import akka.actor.ActorRef;
import akka.event.japi.LookupEventBus;

public class EventBus extends LookupEventBus<String, ActorRef, String>{

	@Override
	public String classify(String arg0) {
		return "";
	}

	@Override
	public int compareSubscribers(ActorRef actorOne, ActorRef actorTwo) {
		return actorOne.compareTo(actorTwo);
	}

	@Override
	public int mapSize() {
		return 128;
	}

	@Override
	public void publish(String message, ActorRef actorRef) {
		actorRef.tell(message, ActorRef.noSender());
	}

}
