package com.spring.security.reosurce.oauth2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	

	
	 @RequestMapping("/hello") //[1]
	 public String home(OAuth2Authentication authentication) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// User currentUser = (User)auth.getPrincipal();
		 //User usre=(User)authentication.getPrincipal();
		 OAuth2AuthenticationDetails tokenDetails=(OAuth2AuthenticationDetails)authentication.getDetails();
		 String access_token=tokenDetails.getTokenValue();
		 System.out.println(access_token);
		// Map<String, Object> additionalInfo = remoteService.getAccessToken(authentication).getAdditionalInformation();
		 DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(access_token);
		 
       // OAuth2AccessToken tokenObj= remoteService.readAccessToken(tokenDetails.getTokenValue());
		// tokenServices.createAccessToken(authentication);
	      return "Hello World";
	 }
	 
	 
	/* @Autowired
	 private AuthorizationServerTokenServices tokenServices;
	
	 @RequestMapping(value = "/getSomething", method = RequestMethod.GET)
	 public UserDetails getSection(OAuth2Authentication authentication,UserInfoTokenServices tokenServie) {
		 tokenServices.createAccessToken(authentication);
		 Map<String, Object> additionalInfo = tokenServices.getAccessToken(authentication).getAdditionalInformation();
		 UserDetails userDetails=new UserDetails();
		 userDetails.setEmailId((String) additionalInfo.get("emailId"));
		 userDetails.setFmnoId((String) additionalInfo.get("fmnoId"));
		 userDetails.setUsername((String) additionalInfo.get("username"));
		 String username = (String) additionalInfo.get("username");
		 Collection<? extends GrantedAuthority> authorities = (Collection<? extends GrantedAuthority>) additionalInfo.get("authorities");

		 // Play with authorities

		 return userDetails;
	 }*/
	 
	 
}
