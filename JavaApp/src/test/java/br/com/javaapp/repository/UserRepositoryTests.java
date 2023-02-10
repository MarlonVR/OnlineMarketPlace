package br.com.javaapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.javaapp.domain.User;

@SpringBootTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void insert() {
		User c = new User();
		c.setEmail("marlon@gmail.com");
		//c.setName("Marlon");
		c.setPassword("123s");
		c.setId(null);
		
		userRepository.save(c);
	}
	
}
