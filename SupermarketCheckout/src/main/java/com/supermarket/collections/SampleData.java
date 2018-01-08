package com.supermarket.collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.supermarket.repository.ItemsRepository;

/**
 * Provides the data class necessary to insert
 * items with unit and special price
 *
 */
@EnableMongoRepositories(basePackageClasses = ItemsRepository.class)
@Configuration
public class SampleData {
	        
	@Bean
    CommandLineRunner commandLineRunner(ItemsRepository itemsRepository) {
        return strings -> {
        	itemsRepository.save(new Items(1,"A",40,new SpecialPrice(1, 3, 70)));
        	itemsRepository.save(new Items(2,"B",10,new SpecialPrice(2, 2, 15)));
        	itemsRepository.save(new Items(3,"C",30));
        	itemsRepository.save(new Items(4,"D",25));
        };
    }


	
}
