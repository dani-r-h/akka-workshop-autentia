package com.autentia.workshop.akka.exercise2;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import scala.Option;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

public class MyActor extends UntypedActor{
	
	private final LoggingAdapter log = Logging.getLogger(this);
	
	public MyActor(){
		log.info("-- Constructor!");
	}
	

	@Override
	public void preStart() throws Exception {
		super.preStart();
		getLogger().info("-- PreStart");
	}
	

	@Override
	public void preRestart(Throwable reason, Option<Object> message) throws Exception {
		super.preRestart(reason, message);
		getLogger().info("-- PreRestart");
	}
	
	@Override
	public void postRestart(Throwable reason) throws Exception {
		super.postRestart(reason);
		getLogger().info("-- PostRestart");
	}
	
	@Override
	public void postStop() throws Exception {
		super.postStop();
		getLogger().info("-- PostStop");
	}
	

	@Override
	public void aroundPreRestart(Throwable reason, Option<Object> message) {
		getLogger().info("-- Before Around PreRestart");
		super.aroundPreRestart(reason, message);
		getLogger().info("-- After Around PreRestart");
	}

	
	@Override
	public void aroundPostRestart(Throwable reason) {
		getLogger().info("-- Before Around PostRestart");
		super.aroundPostRestart(reason);
		getLogger().info("-- After Around PostRestart");
	}

	@Override
	public void aroundPostStop() {
		getLogger().info("-- Before Around PostStop");
		super.aroundPostStop();
		getLogger().info("-- After Around PostStop");
	}


	@Override
	public void aroundPreStart() {
		getLogger().info("-- Before Around PreStart");
		super.aroundPreStart();
		getLogger().info("-- After Around PreStart");
	}
	
	@Override
	public void aroundReceive(PartialFunction<Object, BoxedUnit> receive, Object msg) {
		getLogger().info("-- Before Around Receive");
		super.aroundReceive(receive, msg);
		getLogger().info("-- After Around Receive");
	}

	@Override
	public void onReceive(Object msg) throws Throwable {
		getLogger().info("** Received: "+msg);
		throw new RuntimeException("This is the exception message");
	}
	
	public LoggingAdapter getLogger() {
		return log;
	}
	
	

}
 