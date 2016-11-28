package com.doingfp.oauth;

//import com.doingfp.oauth.service.ServerSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//@Import({ ServerSecurityConfig.class, OAuth2ResourceServerConfig.class })
public class ResourceApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }
}
