package com.example.springSecurity2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Person {
	@Id
	private String username;
	private String password;
	private String role;

}
