package com.xebia.oauth2.config;

import javax.sql.DataSource;

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
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.xebia.oauth2.controller.CustomLogoutSuccessHandler;
import com.xebia.oauth2.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
 
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
        http.authorizeRequests()
            .antMatchers("/login","/logout").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll().and().csrf().disable();
             http.logout().addLogoutHandler(new CustomLogoutSuccessHandler(tokenStore()));
        
    }
    
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
    
    @Bean
	public Md5PasswordEncoder passwordEncoder(){
    	Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		return encoder;
	}
}