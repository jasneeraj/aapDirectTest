package com.neeraj.test.controller;

public class Response {

	private String message;
	
	public Response(){}
	
	public Response(String msg){
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
