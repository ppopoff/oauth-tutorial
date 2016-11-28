package com.doingfp.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import com.doingfp.oauth.OAuth2ResourceServerConfig;
import com.doingfp.oauth.ServerSecurityConfig;

@SpringBootApplication
@Import({ ServerSecurityConfig.class, OAuth2ResourceServerConfig.class })
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
