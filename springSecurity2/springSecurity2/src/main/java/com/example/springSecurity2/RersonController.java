package com.example.springSecurity2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RersonController {

	@GetMapping("hello")
	public String getHello() {
		System.out.println("Hey Babe..");
		return "Come Fast";
	}

	@GetMapping("test")
	public String getTest() {
		System.out.println("I'm Wating ..");
		return "For you";
	}
}
