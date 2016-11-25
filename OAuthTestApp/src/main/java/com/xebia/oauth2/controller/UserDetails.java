package com.xebia.oauth2.controller;

import java.util.Set;

public class UserDetails {
	
	private String username;
	
	private String emailId;
	
	private String fmnoId;
	
	private Set roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFmnoId() {
		return fmnoId;
	}

	public void setFmnoId(String fmnoId) {
		this.fmnoId = fmnoId;
	}

	public Set getRoles() {
		return roles;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}
	
	
	
	

}
