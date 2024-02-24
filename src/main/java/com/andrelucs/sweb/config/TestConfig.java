package com.andrelucs.sweb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andrelucs.sweb.model.Category;
import com.andrelucs.sweb.model.Order;
import com.andrelucs.sweb.model.Product;
import com.andrelucs.sweb.model.User;
import com.andrelucs.sweb.model.enums.OrderStatus;
import com.andrelucs.sweb.repositories.CategoryRepository;
import com.andrelucs.sweb.repositories.OrderRepository;
import com.andrelucs.sweb.repositories.ProductRepository;
import com.andrelucs.sweb.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

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

		User u1 = new User(null,"asd","sda","aqe","asd");
		User u2 = new User(null,"sdddd","sfsdda","afdgqe","ahgsd");
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		
		Order o = new Order(null, Instant.now(), u1, OrderStatus.PAID);
		orderRepository.save(o);
		
		Category c1 = new Category("Comida");
		Category c2 = new Category("Brinquedo");
		Category c3 = new Category("Eletronico");
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

		Product p1 = new Product(null, "Carrinho", "Carrinho normal", 55., "urldocarrinho", c2);
		Product p2 = new Product(null, "Carrinho de controle remoto", "Carrinho eletronico com controle remoto", 110., "urldocarrinhotop", c2);
		p2.addCategory(c3);
		Product p3 = new Product(null, "Bolinho", "Bolinho normal", 12., "urldobolo", c1);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3));		
		
	}
	
}
