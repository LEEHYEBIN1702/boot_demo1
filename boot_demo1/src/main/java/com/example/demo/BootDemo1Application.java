package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerRepository;

@SpringBootApplication
public class BootDemo1Application {
	
	private static final Logger log = LoggerFactory.getLogger(BootDemo1Application.class);


	public static void main(String[] args) {
		SpringApplication.run(BootDemo1Application.class, args);
	}
	
	  @Bean
	  public CommandLineRunner demo(CustomerRepository repository) {
		 // CommandLineRunner 인터페이스를 상속한 클래스를 생성하여 람다식으로 표현
		 return args -> {
			 repository.save(new Customer("Jack", "Bauer"));
			 repository.save(new Customer("Chloe", "O'Brian"));
		     repository.save(new Customer("Kim", "Bauer"));
		     repository.save(new Customer("David", "Palmer"));
		     repository.save(new Customer("Michelle", "Dessler"));

		     // fetch all customers
		     log.info("Customers found with findAll():");
		     log.info("-------------------------------");
		     for (Customer customer : repository.findAll()) {
		     log.info(customer.toString());
		      }
		     log.info("");
		 };
	}
}
