package com.dantas.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.demo.entities.Order;
import com.dantas.demo.repositories.OrderRepository;

// Registra a classe como um componente de servico do spring 
@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	// Metodo para retornar todos os usuarios do banco de dados

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

	public Order update(Long id, Order obj) {
		Order entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Order entity, Order obj) {
		entity.setOrderStatus(obj.getOrderStatus());
		
	}

}
