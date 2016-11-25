package com.xebia.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * https://localhost:9999/uaa/oauth/authorize?response_type=code&client_id=client-with-registered-redirect&redirect_uri=https://google.com
 */
@SpringBootApplication
public class OAuth2SsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2SsoApplication.class, args);
	}
}
