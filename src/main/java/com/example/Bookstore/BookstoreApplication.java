package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger L = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner booktest(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			
			 L.info("save some categories");
			  crepository.save(new Category("Romaani"));
			  crepository.save(new Category("Oppikirja"));
			  crepository.save(new Category("Dekkari"));
			  crepository.save(new Category("Elämänkerta"));
			  crepository.save(new Category("Novelli"));
			  crepository.save(new Category("Sarjakuva"));

			//  brepository.save(new Book("Ilkka Remes", "Mysrkyn silmässä", 1234666, 2004, 24.90, crepository.findByName("Romaani").get(0)));
			
			L.info("fetch books");
			for(Book book : brepository.findAll()) {
				L.info(book.toString());
			}
		};
		
	}

}

