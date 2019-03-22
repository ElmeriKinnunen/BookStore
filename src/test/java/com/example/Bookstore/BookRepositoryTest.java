package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookrepository;

	@Test
	public void findByTitle() {
		List <Book> books = bookrepository.findByTitle("Mysrkyn silmässä");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Ilkka Remes");
	}
	
	@Test
    public void createNewBook() {
    	Book book = new Book("Test title", "Test author", 1234666, 2004, 24.90, new Category("Romaani"));
    	bookrepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
	
	@Test
	public void deleteBook() {
	}
}

