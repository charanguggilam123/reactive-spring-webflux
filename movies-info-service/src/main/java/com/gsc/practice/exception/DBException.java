package com.gsc.practice.exception;

public class DBException extends RuntimeException {
	
	public DBException(String message) {
		super(message);
	}
	
	public DBException(Throwable ex) {
		super(ex);
	}

}
