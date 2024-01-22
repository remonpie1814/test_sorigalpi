package com.spring.sorigalpi.service;

import org.springframework.http.HttpStatus;

public class TestException extends Exception {
	 public TestException(HttpStatus conflict, String string) {}
		 public TestException(String message) {
			 super(message);
		 
	
	 }

}
