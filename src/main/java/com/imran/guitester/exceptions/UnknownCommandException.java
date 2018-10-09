package com.imran.guitester.exceptions;

public class UnknownCommandException extends Exception {

	public UnknownCommandException(String cmdName) {
		super( "Command not found with name=" + cmdName );
	}


}
