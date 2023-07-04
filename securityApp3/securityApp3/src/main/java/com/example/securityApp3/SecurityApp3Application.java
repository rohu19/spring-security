package com.example.securityApp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityApp3Application implements CommandLineRunner {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	static void main(String[] args) {
		SpringApplication.run(SecurityApp3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AppUser p1 = new AppUser();
		p1.setUsername("ram@gmail.com");
		p1.setPassword(bCryptPasswordEncoder.encode("123"));
		p1.setRole("ROLE_SALES");
		appUserRepository.save(p1);

		AppUser p2 = new AppUser();
		p1.setUsername("rohan@gmail.com");
		p1.setPassword(bCryptPasswordEncoder.encode("321"));
		p1.setRole("ROLE_MARKETING");
		appUserRepository.save(p2);

	}

}
