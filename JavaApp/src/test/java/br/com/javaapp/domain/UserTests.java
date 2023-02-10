package br.com.javaapp.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.javaapp.service.UserService;

@SpringBootTest
public class UserTests {
	
	@Autowired
	UserService userService;
	
	@Test
	public void create() {
		
		
	}
}
