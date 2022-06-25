package com.dantas.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.demo.entities.Product;
import com.dantas.demo.repositories.ProductRepository;


// Registra a classe como um componente de servico do spring 
@Service
public class ProductService  {
	
	@Autowired
	private ProductRepository repository;
	
	// Metodo para retornar todos os usuarios do banco de dados
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional <Product> obj = repository.findById(id);
		return obj.get();
	}
	
	
	

}
