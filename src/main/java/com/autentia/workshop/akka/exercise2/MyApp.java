package com.autentia.workshop.akka.exercise2;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class MyApp {

	public static void main(String... args) throws InterruptedException{
		final ActorSystem actorSystem = ActorSystem.create("actorSystem");
		
		final ActorRef actorRef = actorSystem.actorOf(Props.create(MyActor.class), "MyActor");
		actorRef.tell("Message!!", ActorRef.noSender());
		Thread.sleep(100);
		
		actorSystem.terminate();
	}
}
