package com.dantas.demo.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.demo.entities.User;
import com.dantas.demo.repositories.UserRepository;

// Registra a classe como um componente de servico do spring 
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	// Metodo para retornar todos os usuarios do banco de dados

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	// metodo para a incercao do objeto no banco de dados
	public User insert(User obj) {
		return repository.save(obj);
	}

	// metodo para a delecao do usuario
	public void delete(Long id) {
		repository.deleteById(id);
	}

	// metodo para atualizar um usuario
	// Passando o id do usuario e o objeto com o contudo a ser atualizado
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
