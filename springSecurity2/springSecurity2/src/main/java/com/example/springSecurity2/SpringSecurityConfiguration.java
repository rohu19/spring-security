package com.example.springSecurity2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

	@Autowired
	private PersonService personService;

	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(personService);
		dao.setPasswordEncoder(getBCryptPasswordEncoder());
		return dao;
	}

	@Bean
	public SecurityFilterChain chain(HttpSecurity security) throws Exception {

		security.authenticationProvider(getAuthenticationProvider());

		security.authorizeHttpRequests().requestMatchers("/").permitAll().requestMatchers("/test").hasRole("Software")
				.requestMatchers("/hello").hasRole("HR").and().httpBasic();

		return security.build();
	}
}
