package com.andrelucs.sweb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andrelucs.sweb.model.Order;
import com.andrelucs.sweb.model.User;
import com.andrelucs.sweb.model.enums.OrderStatus;
import com.andrelucs.sweb.repositories.OrderRepository;
import com.andrelucs.sweb.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null,"asd","sda","aqe","asd");
		User u2 = new User(null,"sdddd","sfsdda","afdgqe","ahgsd");
		
		
		Order o = new Order(null, Instant.now(), u1, OrderStatus.PAID);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.save(o);
		
	}
	
}
