package com.hcl.Irctc.exception;

public class TicketNotFoundException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;

	public TicketNotFoundException(String message) {
		super();
		this.message = message;
	}

	public TicketNotFoundException() {
		super();
	}

	
}
