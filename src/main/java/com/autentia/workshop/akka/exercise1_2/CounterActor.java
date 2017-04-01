package com.autentia.workshop.akka.exercise1_2;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class CounterActor extends UntypedActor {
	
	private final LoggingAdapter log = Logging.getLogger(this);
	
	private int counter;

	@Override
	public void onReceive(Object msg) throws Throwable {
		if(msg instanceof String && ((String) msg).equals("Stop")) {
			getLogger().info("------------------------- Counter: "+counter);
		}
		
		counter+=1;				
	}
	
	public LoggingAdapter getLogger() {
		return log;
	}

}
