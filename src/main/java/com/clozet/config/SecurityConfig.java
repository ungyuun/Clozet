package com.clozet.config;

import com.clozet.config.jwt.CustomUserDetailsService;
import com.clozet.config.jwt.JwtAuthenticateFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtAuthenticateFilter jwtAuthenticateFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("configure method start");
        http
                .csrf().disable()
                .authorizeRequests()
//                .requestMatchers("/cart/**").authenticated()
                .anyRequest().permitAll()
//                .antMatchers("/user/**").permitAll()
//                .antMatchers("/product/**").permitAll()
//                .anyRequest().authenticated()
                .and()
                .formLogin().disable();

        http.addFilterBefore(jwtAuthenticateFilter, UsernamePasswordAuthenticationFilter.class);  //
        }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    }
