package com.autentia.workshop.akka.exercise5;

import java.util.concurrent.Callable;

import akka.actor.UntypedActor;
import akka.dispatch.Futures;
import akka.dispatch.Mapper;
import akka.dispatch.OnSuccess;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class AsyncWorker extends UntypedActor {
	
	private final LoggingAdapter log = Logging.getLogger(this);
	private final Service service;
	
	public AsyncWorker(final Service service) {
		this.service = service;
	}


	@Override
	public void onReceive(final Object msg) throws Throwable {
		assert msg instanceof Integer;
		
		Futures
			.future(transformIntoInt(msg), getContext().dispatcher())
			.map(multiply(2), getContext().dispatcher())
			.map(add(5), getContext().dispatcher())
			.map(multiply(3), getContext().dispatcher())
			.map(add(-4), getContext().dispatcher())
			.map(resultToPrint(), getContext().dispatcher())
			.onSuccess(print(), getContext().dispatcher());
	}
	
	private Callable<Integer> transformIntoInt(final Object msg){
		return new Callable<Integer>(){
			public Integer call() throws Exception {
				return (Integer) msg;
			}
		};
	}
	
	private Mapper<Integer, Integer> multiply(final int i){
		return new Mapper<Integer, Integer>() {
			@Override
			public Integer apply(Integer parameter) {
				return service.multiply(parameter, i);
			}
		};
	}
	
	private Mapper<Integer, Integer> add(final int i){
		return new Mapper<Integer, Integer>(){
			@Override
			public Integer apply(Integer parameter) {
				return service.add(parameter, i);
			}
		};
	}
	
	private Mapper<Integer, String> resultToPrint(){
		return new Mapper<Integer, String>(){
			@Override
			public String apply(Integer parameter) {
				return service.getResultToPrint(parameter);
			}
		};
	}
	
	private OnSuccess<String> print() {
		return new OnSuccess<String>() {

			@Override
			public void onSuccess(String result) throws Throwable {
				getLogger().info("Result: "+result);
			}
		};
	}

	public LoggingAdapter getLogger() {
		return log;
	}

}
