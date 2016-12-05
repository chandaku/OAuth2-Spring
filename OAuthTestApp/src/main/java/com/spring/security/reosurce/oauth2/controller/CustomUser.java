package com.spring.security.reosurce.oauth2.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String emailId;
	
	private String fmnoId;
	
	

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String emailId, String fmnoId) {
		super(username, password, authorities);
		this.emailId = emailId;
		this.fmnoId = fmnoId;
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
	
	

}
