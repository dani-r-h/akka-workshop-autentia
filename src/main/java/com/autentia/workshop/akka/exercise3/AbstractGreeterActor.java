package com.autentia.workshop.akka.exercise3;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public abstract class AbstractGreeterActor extends UntypedActor {
	
	private final LoggingAdapter log = Logging.getLogger(this);
	private final EventBus eventBus;
	
	public AbstractGreeterActor(final EventBus eventBus) {
		this.eventBus = eventBus;
	}
	
	@Override
	public void preStart() throws Exception {
		super.preStart();
		this.eventBus.subscribe(getSelf(), "");
	}

	@Override
	public void onReceive(Object event) throws Throwable {
		getLogger().info(getGreeting(event));
	}
	
	public LoggingAdapter getLogger() {
		return log;
	}
	
	public abstract String getGreeting(final Object event);

}
