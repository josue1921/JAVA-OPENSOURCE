package com.websystique.springboot.util;

public class CustomSuccessType {

	private String successMessage;
	
	public CustomSuccessType(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
}
