package com.book.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan({"com.book.store.entity"})
@ComponentScan(basePackages = {"com.book.store"})
@EnableCaching
public class BookStoreApplication {
	
	/**
	 *  @author Syyed Sheeraz Shaukat
	 *  
	 * 
	 */

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

}
