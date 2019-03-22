package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository categorypository;

	@Test
	public void findByCategory() {
		List<Category> books = categorypository.findByName("Romaani");
		assertThat(books).hasSize(1);
	}
	
	@Test
    public void createNewCategoryk() {
    	Category category = new Category("Test Category");
    	categorypository.save(category);
    	assertThat(category.getCategoryId()).isNotNull();
    }    
}
