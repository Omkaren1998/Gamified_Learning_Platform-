package com.example.demo.Exception;

public class LandingPageNotFoundException extends RuntimeException {
	public LandingPageNotFoundException(String message, Exception e) {
		super(message);
	}

}
