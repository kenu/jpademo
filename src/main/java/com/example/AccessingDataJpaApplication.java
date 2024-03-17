package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}


	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository, OrderRepository orderRepository) {
		return (args) -> {
			// save a few customers
			customerRepository.save(new Customer("Jack", "Bauer"));
			customerRepository.save(new Customer("Chloe", "O'Brian"));
			customerRepository.save(new Customer("Kim", "Bauer"));
			customerRepository.save(new Customer("David", "Palmer"));
			customerRepository.save(new Customer("Michelle", "Dessler"));

			// save a few orders
			Order order1 = new Order(Optional.ofNullable(customerRepository.findById(1L)).orElse(null), 100.0);
			Order order2 = new Order(Optional.ofNullable(customerRepository.findById(2L)).orElse(null), 200.0);
			orderRepository.save(order1);
			orderRepository.save(order2);

			// fetch all orders
			log.info("Orders found with findAll():");
			log.info("-------------------------------");
			orderRepository.findAll().forEach(order -> {
				log.info(order.toString());
			});
			log.info("");

			// fetch an individual order by ID
			Optional<Order> order = orderRepository.findById(1L);
			log.info("Order found with findById(1L):");
			log.info("--------------------------------");
			log.info(order.toString());
			log.info("");

			// fetch orders by customer ID
			log.info("Orders found with findByCustomerId(1L):");
			log.info("--------------------------------------------");
			orderRepository.findByCustomerId(1L).forEach(ordera -> {
				log.info(ordera.toString());
			});
			log.info("");
		};
	}

}