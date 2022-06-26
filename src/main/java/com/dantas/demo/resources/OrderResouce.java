package com.dantas.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dantas.demo.entities.Order;
import com.dantas.demo.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResouce {

	// dependencia para o servce
	@Autowired
	private OrderService service;

	// Ira retornar a lista de Ordens
	@GetMapping
	public ResponseEntity<List> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// Ira retornar a lista de Ordens por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
