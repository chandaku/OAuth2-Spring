package com.xebia.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.xebia.oauth2.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) 
      throws Exception {
    	auth.userDetailsService(customUserDetailsService)
    	.passwordEncoder(passwordEncoder());
    }
 
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() 
      throws Exception {
        return super.authenticationManagerBean();
    }
 
    @Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/resources/**"); // #3
	  }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    	.authorizeRequests()
    	.antMatchers("/login","/login/form**","/register","/oauth/revoke-token").permitAll() // #4
    	.anyRequest().authenticated() // 7
    	.and()
    	.formLogin()  // #8
    	.loginPage("/login/form") // #9
    	.loginProcessingUrl("/login")
    	.failureUrl("/login/form?error")
    	.permitAll(); // #5
    }
    
    @Bean
	public Md5PasswordEncoder passwordEncoder(){
    	Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		return encoder;
	}
}