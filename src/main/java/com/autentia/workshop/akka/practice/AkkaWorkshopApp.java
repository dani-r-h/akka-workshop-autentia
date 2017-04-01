package com.autentia.workshop.akka.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autentia.workshop.akka.practice.consumer.EventConsumer;
import com.autentia.workshop.akka.practice.executor.FakeMessageExecutor;
import com.autentia.workshop.akka.practice.executor.MessageExecutor;

import akka.actor.ActorSystem;

public class AkkaWorkshopApp {
	
	
	private static final String RABBIT_HOST = "5.56.60.112";
	private static final int RABBIT_PORT = 5672;
	
	private static final String QUEUE_NAME = "workshop_queue";
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private final ActorSystem actorSystem = ActorSystem.create("actorSystem");
	//FIXME Fulfill the messageExecutor implementation
	private final MessageExecutor messageExecutor = new FakeMessageExecutor(actorSystem);

	public static void main(String[] args) {
		final AkkaWorkshopApp app = new AkkaWorkshopApp();
		
		app.addShutdownHook();
		app.execute();			
	}
	
	public void execute() {
		final EventConsumer eventConsumer = new EventConsumer(RABBIT_HOST, RABBIT_PORT);
		eventConsumer.startConsuming(QUEUE_NAME, messageExecutor);
	}

	private void addShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				log.info("--------------------------- Terminate");
				actorSystem.terminate();
			}));		
	}


}
