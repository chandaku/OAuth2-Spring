package com.spring.security.reosurce.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.spring.security.reosurce.oauth2.config1.MethodSecurityConfig;
import com.spring.security.reosurce.oauth2.config1.OAuth2ResourceConfig;

@SpringBootApplication
@EnableAutoConfiguration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, /*securedEnabled = true, */proxyTargetClass = true)
@Import({ OAuth2ResourceConfig.class, MethodSecurityConfig.class })
public class OAuthTestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthTestAppApplication.class, args);
	}
}
