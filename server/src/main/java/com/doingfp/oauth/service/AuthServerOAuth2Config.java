package com.doingfp.oauth.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.*;
import org.springframework.security.oauth2.config.annotation.web.configurers.*;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;


/**
 *
 * In order to persist the tokens, we used a JdbcTokenStore
 * We registered a client for the “implicit” grant type
 * We registered another client and authorized the “password“, “authorization_code” and “refresh_token” grant types
 * In order to use the “password” grant type we need to wire in and use the AuthenticationManager bean
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Value("classpath:schema.sql")
    private Resource schemaScript;

    @Autowired
    private Environment env;


    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.allowFormAuthenticationForClients();
    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
          .withClient("sampleClientId")
          .authorizedGrantTypes("implicit")
          .scopes("read")
          .autoApprove(true)
          .and()
          .withClient("clientIdPassword")
          .secret("secret")
          .authorizedGrantTypes("password","authorization_code", "refresh_token")
          .scopes("read");
    }

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
    // ----------------------------------------------------------------------------------


    // Token store configuration
    //// Remote token service
    @Primary
    @Bean
    public RemoteTokenServices tokenService() {
        final String baseUrl = env.getProperty("resource.baseUrl");

        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(baseUrl + "/spring-security-oauth-server/oauth/check_token");
        tokenService.setClientId("fooClientIdPassword");
        tokenService.setClientSecret("secret");
        return tokenService;
    }
}
