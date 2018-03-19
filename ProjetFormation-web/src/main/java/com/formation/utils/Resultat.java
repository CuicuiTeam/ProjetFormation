package com.formation.utils;

public class Resultat {
	
	private String message;
	private boolean success;
	private Object payload;
	
	public Resultat() {
	}
	
	public Resultat(String message, boolean success, Object payload) {
		this.message = message;
		this.success = success;
		this.payload = payload;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}
	

}
