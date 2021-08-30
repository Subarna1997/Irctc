package com.hcl.Irctc.exception;

public class BookingNotDoneException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	String message;


	public BookingNotDoneException(String message) {
		super();
		this.message = message;
	}


	public BookingNotDoneException() {
		super();
	}
	
	

}
