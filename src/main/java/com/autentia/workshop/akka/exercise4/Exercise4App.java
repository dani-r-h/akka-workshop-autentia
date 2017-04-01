package com.autentia.workshop.akka.exercise4;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Exercise4App {

	public static void main(String[] args) throws InterruptedException {

		final ActorSystem actorSystem = ActorSystem.create("actorSystem");

		final ActorRef actorRef = actorSystem.actorOf(Props.create(Master.class), "Master");

		for (int i = 0; i < 100; i++) {
			actorRef.tell(i, ActorRef.noSender());
			Thread.sleep(500);
		}

		 actorSystem.terminate();
	}
}
