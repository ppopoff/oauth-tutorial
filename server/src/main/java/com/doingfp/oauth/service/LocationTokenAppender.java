package com.doingfp.oauth.service;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class LocationTokenAppender implements TokenEnhancer{

    // for now returns token as it is

    /**
     * TODO: append location info to JWT token
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        //final Map<String, Object> additionalInfo = new HashMap<>();
        //Object organization = additionalInfo.put("organization", authentication.getName() + randomAlphabetic(4));
        //((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
