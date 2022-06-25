package com.dantas.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dantas.demo.entities.Product;
import com.dantas.demo.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResouce {
	
	//dependencia para o servce 
	@Autowired
	private ProductService service;
	
	//Ira retornar a lista de usuarios
	@GetMapping
	public ResponseEntity<List> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Ira retornar a lista de usuarios por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
