package com.autentia.workshop.akka.exercise1;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.LoggingAdapter;
import akka.testkit.TestActorRef;

public class GreeterActorTest {

	@Test
	public void should_greet_when_a_name_is_received() throws Throwable {
		//given
		final GreeterService greeterService = mock(GreeterService.class);
		when(greeterService.greet("World")).thenReturn("Hello World!");

		final ActorSystem actorSystem = ActorSystem.create("testActorSystem");		
		final TestActorRef sutActorRef = TestActorRef.create(actorSystem, Props.create(GreeterActor.class, greeterService), "GreeterActorName");
		final GreeterActor sut = spy((GreeterActor) sutActorRef.underlyingActor());
		when(sut.getLogger()).thenReturn(mock(LoggingAdapter.class));
		
		//when
		sut.onReceive("World");
		
		//then
		verify(((GreeterActor) sut).getLogger()).info("Hello World!"); 
	}
}
