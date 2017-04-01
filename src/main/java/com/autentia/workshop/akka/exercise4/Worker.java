package com.autentia.workshop.akka.exercise4;


import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Worker extends UntypedActor{
	
	private final LoggingAdapter log = Logging.getLogger(this);
			
	@Override
	public void onReceive(Object msg) throws Throwable {
		getLogger().info("Msg: "+msg);
	}
	
	public LoggingAdapter getLogger(){
		return log;
	}

}
