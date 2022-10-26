package com.springassingment4.entity;

import org.springframework.stereotype.Component;

@Component
public class Response {
	private String responseStatus;
	private String responseMessage;
	public Response(String responseStatus, String responseMessage) {
		super();
		this.responseStatus = responseStatus;
		this.responseMessage = responseMessage;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@Override
	public String toString() {
		return "Response [responseStatus=" + responseStatus + ", responseMessage=" + responseMessage + "]";
	}
	
	
}
