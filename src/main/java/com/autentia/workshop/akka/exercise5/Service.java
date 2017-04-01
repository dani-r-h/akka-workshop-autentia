package com.autentia.workshop.akka.exercise5;

public class Service {

	public Integer multiply(Integer number, int i) throws RuntimeException {
		try {
			Thread.sleep(500);
			return number * i;
		}catch(InterruptedException e){
			throw new RuntimeException();
		}
		
	}

	public Integer add(Integer number, int i) throws RuntimeException {
		try {
			Thread.sleep(500);
			return number + i;
		}catch(InterruptedException e){
			throw new RuntimeException();
		}
	}

	public String getResultToPrint(Integer number) throws RuntimeException {
		try {
			Thread.sleep(500);
			return String.valueOf(number);
		}catch(InterruptedException e){
			throw new RuntimeException();
		}

	}

}
