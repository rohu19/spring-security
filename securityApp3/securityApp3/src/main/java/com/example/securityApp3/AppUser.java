package com.example.securityApp3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class AppUser {

	@Id
	private String username;
	private String password;
	private String role;
}
