package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userrepository;
	
	@Test
	public void findByUser() {
		userrepository.findByUsername("ADMIN");
	}
	
	@Test
	public void createNewUser() {
		User user = new User("TestUser", "password", "mail@mail.com", "USER");
		userrepository.save(user);
		assertThat(user.getUsername()).isNotNull();
	}

}
