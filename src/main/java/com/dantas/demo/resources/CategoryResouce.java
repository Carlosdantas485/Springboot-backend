package com.dantas.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dantas.demo.entities.Category;
import com.dantas.demo.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResouce {
	
	//dependencia para o servce 
	@Autowired
	private CategoryService service;
	
	//Ira retornar a lista de categorias
	@GetMapping
	public ResponseEntity<List> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Ira retornar a lista de categorias por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
