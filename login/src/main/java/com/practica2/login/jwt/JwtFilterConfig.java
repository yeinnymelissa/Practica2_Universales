package com.practica2.login.jwt;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtFilterConfig {
	@Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
        FilterRegistrationBean<JwtFilter>  filter= new FilterRegistrationBean<JwtFilter>();
        filter.setFilter(new JwtFilter());
        
       filter.addUrlPatterns("/api/auth/hola");
    return filter;
    }
}
