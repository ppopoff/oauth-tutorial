package com.doingfp.oauth.service;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class LocationTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(final OAuth2AccessToken accessToken,
                                     final OAuth2Authentication authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("location", "Voronezh");
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
