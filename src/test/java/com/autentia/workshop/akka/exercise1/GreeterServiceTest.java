package com.autentia.workshop.akka.exercise1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class GreeterServiceTest {

	@Test
	public void should_return_greetings_given_a_name(){
		//given
		final GreeterService sut = new GreeterService();
		
		//when
		final String expectedGreetings = sut.greet("World");
		
		//then
		assertThat(expectedGreetings, is(equalTo("Hello World!")));
	}
}
