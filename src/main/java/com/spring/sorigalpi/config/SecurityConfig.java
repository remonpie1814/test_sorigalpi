package com.spring.sorigalpi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigureAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
	}
@Bean
public PwdEncoder pwdEncoder() {
	
	return new BCryptPwdEncoder();
}

}
