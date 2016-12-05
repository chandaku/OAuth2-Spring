package com.spring.security.reosurce.oauth2.controller;
/**
 * 
 */


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private String email;
	
	private String passwd;
	
	private Date dob;
	
	private Set<Role> roles = new HashSet<>();
	
	public User() {
	}

	public User(int id, String name, String email, String passwd, Date dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.passwd = passwd;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email
				+ ", dob=" + dob + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
