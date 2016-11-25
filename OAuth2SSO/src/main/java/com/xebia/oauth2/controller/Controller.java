package com.xebia.oauth2.controller;

import java.security.Principal;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	 @RequestMapping("/hello") //[1]
	 public String home() {
	      return "Hello World";
	 }
	 
	 @RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }
}
