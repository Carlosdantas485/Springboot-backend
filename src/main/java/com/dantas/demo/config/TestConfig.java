package com.dantas.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dantas.demo.entities.Order;
import com.dantas.demo.entities.User;
import com.dantas.demo.repositories.OrderRepository;
import com.dantas.demo.repositories.UserRepository;

// Esta anotatio indica que euma classe de configuracao
@Configuration
// Esta anotation indica que e uma configuracao especifica do perfil Test
@Profile("test")
// Ao colocar implements CommandLineRunner ira executar o conteudo ao iniciar
public class TestConfig implements CommandLineRunner {
	
	//Esta anotation resolve a dependencia do Testconfig com o userRepository para poder usar a instancia do userRepository
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// O null no campo ID indica que i ID será gerado automaticamnete
		User u1 = new User(null, "Maria do Carmo", "maria@123", "987654321", "senha", "1000");
		User u2 = new User(null, "Carlos Dantas", "carlos@123", "987654321", "senha", "5000");
		
		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07z"), u1);
		Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10z"), u2);
		Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22z"), u1);
		
		//salva os usuarios no banco de dados
		//Pasando uma lista de usuarios 
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
	
	
}
