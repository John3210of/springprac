package com.yohan.spring1.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class WebConfig implements WebMvcConfigurer {
    @Override public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET","POST","DELETE","PUT");
    }

//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()); // 추가
//
//        httpSecurity
//
//        .authorizeRequests()
//                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll(); // 추가
//    }
}