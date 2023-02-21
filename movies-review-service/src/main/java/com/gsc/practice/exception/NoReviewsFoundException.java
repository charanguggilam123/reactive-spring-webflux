package com.gsc.practice.exception;

public class NoReviewsFoundException extends RuntimeException {
	
	public NoReviewsFoundException(String message) {
		super(message);
	}
	
	public NoReviewsFoundException(Throwable ex) {
		super(ex);
	}

}
