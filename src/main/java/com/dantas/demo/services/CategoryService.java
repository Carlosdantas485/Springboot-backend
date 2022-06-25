package com.dantas.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.demo.entities.Category;
import com.dantas.demo.repositories.CategoryRepository;


// Registra a classe como um componente de servico do spring 
@Service
public class CategoryService  {
	
	@Autowired
	private CategoryRepository repository;
	
	// Metodo para retornar todos os usuarios do banco de dados
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional <Category> obj = repository.findById(id);
		return obj.get();
	}
	
	
	

}
