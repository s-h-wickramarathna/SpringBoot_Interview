package com.springJwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("http://localhost:4200") // Allow requests from the Angular app
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify allowed methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true) // Enable credentials
                .maxAge(3600); // Cache preflight response
    }
}