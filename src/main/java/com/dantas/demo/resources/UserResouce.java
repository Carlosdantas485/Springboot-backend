package com.dantas.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	
	//para criar um usuario
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		
		//cria um componente tipo uri onde sera apresentado o ID
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			//O created(paramentro tipo URI)
		return ResponseEntity.created(uri).body(obj);
	}
	
	
	
}
