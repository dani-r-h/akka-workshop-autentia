package com.autentia.workshop.akka.exercise5;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Exercise5App {

	public static void main(String[] args) throws InterruptedException {
		
		final ActorSystem actorSystem = ActorSystem.create("actorSystem");
//		final ActorRef actorRef = actorSystem.actorOf(Props.create(SyncWorker.class), "syncWorker");
		final ActorRef actorRef = actorSystem.actorOf(Props.create(AsyncWorker.class), "asyncWorker");
		
		for (int i = 0; i < 100; i++) {
			actorRef.tell(i, ActorRef.noSender());
			Thread.sleep(200);
		}
		
		actorSystem.terminate();		
	}
	
	
}
