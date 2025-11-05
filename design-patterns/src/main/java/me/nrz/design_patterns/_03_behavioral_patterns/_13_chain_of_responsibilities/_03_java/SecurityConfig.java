package me.nrz.design_patterns._03_behavioral_patterns._13_chain_of_responsibilities._03_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // 모든 요청 허용
            .csrf(csrf -> csrf.disable()); // (옵션) CSRF 비활성화

        return http.build();
    }
}

