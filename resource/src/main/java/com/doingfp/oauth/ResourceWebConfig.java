package com.doingfp.oauth;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
@ComponentScan({ "com.doingfp.oauth" })
public class ResourceWebConfig extends WebMvcConfigurerAdapter {}
