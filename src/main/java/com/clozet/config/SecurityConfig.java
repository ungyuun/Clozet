package com.clozet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("configure method start");
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll()
//                .antMatchers("/user/**").permitAll()
//                .antMatchers("/product/**").permitAll()
//                .anyRequest().authenticated()
                .and()
                .formLogin().disable();
    }
}