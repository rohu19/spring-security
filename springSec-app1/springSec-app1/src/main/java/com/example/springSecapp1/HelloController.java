package com.example.springSecapp1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("hello")
	public String syaHello() {
		System.out.println("hey bsdk");
		return "from hello api";
	}

	@RequestMapping("test")
	public String syaTest() {
		System.out.println("hey MSD");
		return "from hello MSD";
	}

}
