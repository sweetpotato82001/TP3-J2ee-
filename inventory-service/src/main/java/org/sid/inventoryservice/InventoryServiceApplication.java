package org.sid.inventoryservice;

import org.sid.inventoryservice.enteties.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return  args -> {
				productRepository.save(new Product(1, "cocacola" , 10, 5));
				productRepository.save(new Product(2 , "doritos" , 20, 3));
				productRepository.save(new Product(3 , "indomie" , 5, 2));
				productRepository.findAll().forEach(p->{
					System.out.println(p.getName());
				});
		};
	}

}
