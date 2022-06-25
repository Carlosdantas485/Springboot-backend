package com.dantas.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dantas.demo.entities.Category;
import com.dantas.demo.entities.Order;
import com.dantas.demo.entities.Product;
import com.dantas.demo.entities.User;
import com.dantas.demo.entities.enums.OrderStatus;
import com.dantas.demo.repositories.CategoryRepository;
import com.dantas.demo.repositories.OrderRepository;
import com.dantas.demo.repositories.ProductRepository;
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
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Aqui vai alumas palavras aleatorias", 90.5,"");
		Product p2 = new Product(null, "Smart TV", "frase de impacto para teste", 2190.0, "");
		Product p3 = new Product(null, "Mackbook Pro", "colocar palavras bonitas teste", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "comprar um pc gamer nas lojas online", 1200.0, "");
		Product p5 = new Product(null, "Rails for Demmies", "Este livro e muito bom para ler", 100.99,"");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		//Adiciona o produto "p1" na categoria "cat2"
		p1.getCategosires().add(cat2);
		
		//Adiciona o produto "p2" na categoria "cat1"
		p2.getCategosires().add(cat1);
		
		//Adiciona o produto "p3" na categoria "cat3"
		p2.getCategosires().add(cat3);
		
		//Adiciona o produto "p2" na categoria "cat3"
		p3.getCategosires().add(cat3);
		
		//Adiciona o produto "p4" na categoria "cat5"
		p4.getCategosires().add(cat3);
		
		//Adiciona o produto "p5" na categoria "cat2"
		p5.getCategosires().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		// O null no campo ID indica que i ID será gerado automaticamnete
		User u1 = new User(null, "Maria do Carmo", "maria@123", "987654321", "senha", 1000.0);
		User u2 = new User(null, "Carlos Dantas", "carlos@123", "987654321", "senha", 5000.0);
		
		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10z"), OrderStatus.WAITING_PAYMANT, u2);
		Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22z"), OrderStatus.WAITING_PAYMANT, u1);
		
		//salva os usuarios no banco de dados
		//Pasando uma lista de usuarios 
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
	
	
}
