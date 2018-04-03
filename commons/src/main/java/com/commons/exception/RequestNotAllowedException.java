package com.commons.exception;

public class RequestNotAllowedException  extends RuntimeException{
	public RequestNotAllowedException() {
		
	}
	
	public RequestNotAllowedException(String message) {
		super(message);
	}
	
	public RequestNotAllowedException(String message, Throwable obj) {
		super(message, obj);
	}
}
