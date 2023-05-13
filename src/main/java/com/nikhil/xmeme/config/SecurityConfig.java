package com.nikhil.xmeme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        // final UserDetails user = User.withUsername("nikhil")
        // .password(passwordEncoder().encode("p")).roles("NORMAL")
        // .build();

        return new CustomUserDetailsService();

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable().authorizeHttpRequests()
                .requestMatchers("/", "/signup").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();

        return httpSecurity.build();
    }

    /**
     * To support @DeleteMapping Request
     */
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

}
