package com.clozet.model.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class Cors implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        System.out.println("addCorsMappings execute");
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedOrigins("http://192.168.0.16:3000")
                .allowedHeaders("*")
                .exposedHeaders("*")
                .allowedMethods("OPTIONS","GET","POST","PUT","DELETE")
                .allowCredentials(false);
    }
}