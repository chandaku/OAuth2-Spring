package com.xebia.oauth2.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;


/**
 * Spring Security logout handler
 */
@Component
public class CustomLogoutSuccessHandler
        implements LogoutHandler {


    private static final String BEARER_AUTHENTICATION = "Bearer ";
    private static final String HEADER_AUTHORIZATION = "authorization";
    
    public CustomLogoutSuccessHandler(TokenStore tokenStore) {
    	this.tokenStore=tokenStore;
	}
    private TokenStore tokenStore;

    public void logout(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication)
            {
        String token = request.getHeader(HEADER_AUTHORIZATION);
        if (token != null && token.startsWith(BEARER_AUTHENTICATION)) {
            OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token.replace(BEARER_AUTHENTICATION, "").trim());
            if (oAuth2AccessToken != null) {
                tokenStore.removeAccessToken(oAuth2AccessToken);
            }
        }
        
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication auth=context.getAuthentication();
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		context.setAuthentication(null);
		SecurityContextHolder.clearContext();
		request.getSession().invalidate();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
		for(int i=0;i<cookies.length;i++){
			cookies[i].setValue("");
            cookies[i].setPath(request.getServletContext().getContextPath()+"/");
            cookies[i].setMaxAge(0);
            cookies[i].setDomain(request.getServerName());
            
            response.addCookie(cookies[i]);
		}
		}
		response.setStatus(HttpServletResponse.SC_OK);
    }
}