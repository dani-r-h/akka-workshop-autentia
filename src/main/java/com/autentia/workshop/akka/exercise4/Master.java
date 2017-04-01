package com.autentia.workshop.akka.exercise4;

import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;

public class Master extends UntypedActor {
	
	private final LoggingAdapter log = Logging.getLogger(this);
	private final Router router;
	
	public Master() {
		
		final List<Routee> routees = new ArrayList<Routee>();
		
		for (int i = 0; i < 5; i++) {
			final ActorRef ref = getContext().actorOf(Props.create(Worker.class), "worker"+i);
			getContext().watch(ref);
			routees.add(new ActorRefRoutee(ref));
		}
		
		this.router = new Router(new RoundRobinRoutingLogic(), routees);
	}

	@Override
	public void onReceive(Object msg) throws Throwable {
		if(msg instanceof Integer){
			router.route(msg, getSender());
		}else if(msg instanceof Terminated){
			getLogger().info("Terminated!" + ((Terminated)msg).actor());
		}
	}
	
	public LoggingAdapter getLogger() {
		return log;
	}

}
