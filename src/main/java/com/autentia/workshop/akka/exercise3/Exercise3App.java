package com.autentia.workshop.akka.exercise3;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Exercise3App {

	public static void main(String[] args) throws InterruptedException{
		
		final ActorSystem actorSystem = ActorSystem.create("actorSystem");
		final EventBus eventBus = new EventBus();
		
		final ActorRef englishGreeterActor = actorSystem.actorOf(Props.create(EnglishGreeterActor.class, eventBus), "englishActor");
		final ActorRef spanishGreeterActor = actorSystem.actorOf(Props.create(SpanishGreeterActor.class, eventBus), "spanishActor");
		final ActorRef italianGreeterActor = actorSystem.actorOf(Props.create(ItalianoGreeterActor.class, eventBus), "italianActor");
		Thread.sleep(100);
		
		eventBus.publish("Dani");
	
		Thread.sleep(100);
		actorSystem.terminate();		
	}
}
