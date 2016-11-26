package com.xebia.oauth2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.xebia.oauth2.tokenforgery.CustomTokenEnhancer;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private static final String RESOURCE_ID = "resource";
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private DataSource dataSource;
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) 
      throws Exception {
        clients.
        jdbc(dataSource)
         /*.withClient("sampleClientId")
          .secret("secret")
          .authorizedGrantTypes("implicit")
          .scopes("read")
          .resourceIds(RESOURCE_ID)
          .autoApprove(true)
          .and()
          .withClient("clientIdPassword")
          .secret("secret")
          .authorizedGrantTypes(
            "password")
          .scopes("read")
          .resourceIds(RESOURCE_ID)
          .and().
         withClient("acme")
          .secret("secret")
          .authorizedGrantTypes(
            "authorization_code")
          .scopes("read","trust")
          .resourceIds(RESOURCE_ID)*/;
    }
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) 
      throws Exception {
        endpoints.tokenEnhancer(tokenEnhancer())
          .tokenStore(tokenStore())
          .authenticationManager(authenticationManager);
    }
    
    
    @Bean
    @Primary
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setTokenEnhancer(tokenEnhancer());
        return tokenServices;
    }

    // Some @Bean here like tokenStore

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }
    
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
    
    @Override
    public void configure(
      AuthorizationServerSecurityConfigurer oauthServer) 
      throws Exception {
        oauthServer
          .tokenKeyAccess("permitAll()")
          .checkTokenAccess("isAuthenticated()");
    }

}