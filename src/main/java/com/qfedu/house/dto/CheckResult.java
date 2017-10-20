package com.qfedu.house.dto;

public class CheckResult {
	private String username;
	private boolean valid;
	private String message;
	private String picture;

	public CheckResult(String username,boolean valid, String message, String picture) {
		this.username = username;
		this.valid = valid;
		this.message = message;
		this.picture = picture;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isValid() {
		return valid;
	}

	public String getMessage() {
		return message;
	}

	public String getPicture() {
		return picture;
	}

}
