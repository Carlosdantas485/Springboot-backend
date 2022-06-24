package com.dantas.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dantas.demo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResouce {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@123", "987654321","123456789", "0,0");
		return ResponseEntity.ok().body(u);
	}
}
