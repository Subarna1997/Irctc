package com.hcl.Irctc.exception;

public class TrainNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	String message;


	public TrainNotFoundException(String message) {
		super();
		this.message = message;
	}


	public TrainNotFoundException() {
		super();
	}
	
	
}
