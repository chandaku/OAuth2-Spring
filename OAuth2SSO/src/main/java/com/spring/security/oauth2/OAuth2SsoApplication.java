package com.spring.security.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/*
 * https://localhost:9999/uaa/oauth/authorize?response_type=code&client_id=client-with-registered-redirect&redirect_uri=https://google.com
 */
@SpringBootApplication
public class OAuth2SsoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(OAuth2SsoApplication.class, args);
	}
}
