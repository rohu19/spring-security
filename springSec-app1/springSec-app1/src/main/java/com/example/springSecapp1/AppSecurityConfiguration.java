package com.example.springSecapp1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfiguration {

	@Bean
	public UserDetailsService getUser(BCryptPasswordEncoder encoder) {

		InMemoryUserDetailsManager usermaManager = new InMemoryUserDetailsManager();
		usermaManager.createUser(User.withUsername("rohan").password(encoder.encode("123")).roles("Developer").build());

		usermaManager.createUser(User.withUsername("shreya").password(encoder.encode("321")).roles("Admin").build());
      
		usermaManager.createUser(User.withUsername("golu").password(encoder.encode("3210")).roles("HR", "ACC").build());
		return usermaManager;

	}

	@Bean
	public SecurityFilterChain authorization(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests().requestMatchers("/").permitAll().requestMatchers("/hello").hasRole("Admin")
				.requestMatchers("/test").hasAnyRole("HR", "ACC").and().httpBasic();

		return http.build();
	}

	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
}
