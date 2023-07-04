package com.example.securityApp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.GET;

@RestController
public class AppUserController {

	@Autowired
	private AppUserService appUserService;

	@GetMapping("hello")
	public String hello() {
		System.out.println("From Hello");
		return "lalalalalalalalalalalala";
	}

	@GetMapping("test")
	public String test() {
		System.out.println("From Test");
		return "Kakakakakakaka";
	}
}
