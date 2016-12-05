package com.spring.security.oauth2.tokenforgery;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.spring.security.oauth2.user.User;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
       // User user = (User) authentication.getPrincipal();
       // final Map<String, Object> additionalInfo = new HashMap<>();

       /* additionalInfo.put("username",user.getName());
        additionalInfo.put("emailId",user.getEmail());
        additionalInfo.put("fmnoId",user.getEmail());
      *///  additionalInfo.put("authorities", user.getRoles());
        
        
       // authentication.setDetails(additionalInfo);
        
        //((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

        return accessToken;
    }

}