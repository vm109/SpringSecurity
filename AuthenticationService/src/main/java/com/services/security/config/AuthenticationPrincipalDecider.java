package com.services.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.services.security.services.GetUserDetails;

@Configuration
public class AuthenticationPrincipalDecider  extends WebSecurityConfigurerAdapter{
	@Autowired
	GetUserDetails userDetailsService;
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests().antMatchers("/admin","/content").authenticated()
		.antMatchers("/amdin").hasRole("ADMIN")
		.antMatchers("/content").hasRole("USER")
		.anyRequest().permitAll()
		.and().formLogin();
	}
}
