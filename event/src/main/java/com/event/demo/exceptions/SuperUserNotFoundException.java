package com.event.demo.exceptions;

public class SuperUserNotFoundException extends Exception {


	public SuperUserNotFoundException(String message) {
		super(message);
	}
	
	public SuperUserNotFoundException(String message,Throwable cause) {
		super(message);
	}
	
}
