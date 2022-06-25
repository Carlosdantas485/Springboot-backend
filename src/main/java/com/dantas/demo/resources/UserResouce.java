package com.dantas.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dantas.demo.entities.User;
import com.dantas.demo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResouce {
	
	//dependencia para o servce 
	@Autowired
	private UserService service;
	
	//Ira retornar a lista de usuarios
	@GetMapping
	public ResponseEntity<List> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Ira retornar a lista de usuarios por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
