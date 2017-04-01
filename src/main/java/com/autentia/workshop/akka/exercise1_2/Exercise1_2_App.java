package com.autentia.workshop.akka.exercise1_2;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Exercise1_2_App {

	public static void main(String[] args) throws InterruptedException {
		final ActorSystem actorSystem = ActorSystem.create("actorSystem");
		
		final ActorRef actorRef = actorSystem.actorOf(Props.create(CounterActor.class), "counter");
		
		for (int i = 0; i < 100; i++) {
			actorRef.tell(i, ActorRef.noSender());
		}
		
		actorRef.tell("Stop", ActorRef.noSender());
		
		
		Thread.sleep(100);	
		actorSystem.terminate();
	}
}
