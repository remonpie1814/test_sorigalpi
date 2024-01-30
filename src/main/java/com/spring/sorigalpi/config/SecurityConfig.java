package com.spring.sorigalpi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {


    // 회원의 패스워드 암호화
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){

        return new BCryptPasswordEncoder();
    }

    // 시큐리티 필터 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeRequests() // 요청에 대한 권한 설정
            .antMatchers("/").authenticated()
            .anyRequest().permitAll();

        httpSecurity
            .formLogin() // Form Login 설정
                .loginPage("/member/login")
                .loginProcessingUrl("/api/login")
                .defaultSuccessUrl("/")
            .and()
                .logout()
            .and()
                .csrf().disable();

        return httpSecurity.build();

    }
}