package com.autentia.workshop.akka.exercise1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Exercise1App {

	public static void main(String[] args){
		
		final ActorSystem actorSystem = ActorSystem.create("actorSystem");
		final GreeterService greeterService = new GreeterService();
		
		final ActorRef actorRef = actorSystem.actorOf(Props.create(GreeterActor.class, greeterService), "GreeterActorName");
		actorRef.tell("World", ActorRef.noSender());		
		
		actorSystem.terminate();
	}
}
