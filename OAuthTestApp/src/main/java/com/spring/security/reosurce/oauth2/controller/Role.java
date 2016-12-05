package com.spring.security.reosurce.oauth2.controller;
/**
 * 
 */


import java.io.Serializable;


public class Role implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String roleName;
	
	public Role() {
	}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}
	public Role(Integer id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
