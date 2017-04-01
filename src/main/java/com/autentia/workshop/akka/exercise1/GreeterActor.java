package com.autentia.workshop.akka.exercise1;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class GreeterActor extends UntypedActor {

	private final LoggingAdapter log = Logging.getLogger(this);
	private final GreeterService greeterService;
	
	public GreeterActor(final GreeterService greeterService) {
		this.greeterService = greeterService;
	}

	@Override
	public void onReceive(Object msg) throws Throwable {
		assert msg instanceof String;
		
		this.getLogger().info(greeterService.greet((String) msg));
	}
	
	protected LoggingAdapter getLogger() {
		return log;
	}

}
