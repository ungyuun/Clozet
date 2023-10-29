package com.clozet.config;

//import com.clozet.config.jwt.CustomUserDetailsService;
//import com.clozet.config.jwt.JwtAuthenticateFilter;
import com.clozet.model.common.Cors;
import com.clozet.security.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsFilter corsFilter;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(corsFilter)
                .authorizeRequests()
                .antMatchers("/cart/**").authenticated()
                .anyRequest().permitAll();

        http
                .oauth2Login().loginPage("/auth/login");

        http.addFilterBefore(new JwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}