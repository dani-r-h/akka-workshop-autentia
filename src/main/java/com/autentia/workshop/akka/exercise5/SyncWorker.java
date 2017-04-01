package com.autentia.workshop.akka.exercise5;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class SyncWorker extends UntypedActor {

	private final LoggingAdapter log = Logging.getLogger(this);
	private final Service service;
	
	public SyncWorker(final Service service) {
		this.service = service;
	}

	@Override
	public void onReceive(Object msg) throws Throwable {
		assert msg instanceof Integer;
		
		Integer number = (Integer) msg; 
		
		number = service.multiply(number, 2);
		number = service.add(number, 5);
		number = service.multiply(number, 3);
		number = service.add(number, -4);
		String result = service.getResultToPrint(number);
		
		getLogger().info("Result: "+result);
	}
	
	public LoggingAdapter getLogger() {
		return log;
	}

}
