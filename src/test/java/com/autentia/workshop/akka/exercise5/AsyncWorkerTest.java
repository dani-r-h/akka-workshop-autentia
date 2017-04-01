package com.autentia.workshop.akka.exercise5;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.LoggingAdapter;
import akka.testkit.TestActorRef;

public class AsyncWorkerTest {
	
	private final ActorSystem actorSystem = ActorSystem.create("testActorSystem");

	private final Service service = mock(Service.class);
	private final LoggingAdapter log = mock(LoggingAdapter.class);
	
	private AsyncWorker sut;
	
	
	@Before
	public void setup() {
		final TestActorRef<AsyncWorker> ref = TestActorRef.create(actorSystem, Props.create(AsyncWorker.class, service));
		sut = spy(ref.underlyingActor());
	}
	
	@Test
	public void should_make_all_operations() throws Throwable {
		//given
		final Integer number = 5;
		when(sut.getLogger()).thenReturn(log);
		when(service.multiply(number, 2)).thenReturn(10);
		when(service.add(10, 5)).thenReturn(15);
		when(service.multiply(15, 3)).thenReturn(45);
		when(service.add(45, -4)).thenReturn(41);
		when(service.getResultToPrint(41)).thenReturn("41");
		
		
		//when
		sut.onReceive(number);
		Thread.sleep(100);
		
		
		//then
		verify(sut.getLogger()).info("Result: 41");	
	}
}
