package com.example.authentication;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.authentication.models.User;
import com.example.authentication.repositories.UserRepository;
import com.example.authentication.services.LoginService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
public class LoginServiceTest {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserRepository actRep;
	
	@MockBean
	private UserRepository userRep;
	
	@Test
	public void testAddUser() {
		
		User user = new User();
		user.setId(1);
		user.setName("Dummy");
		user.setEmail("dummy@dummy.com");
		user.setPassword("password");
		
		Mockito.when(userRep.save(user)).thenReturn(user);
			
		assertTrue(loginService.AddUser(user));
	}
	
	@Test
	public void testAuthenticateUser() {
		
		User user = new User();
		user.setId(1);
		user.setName("Dummy");
		user.setEmail("dummy@dummy.com");
		user.setPassword("password");
		
		Mockito.when(userRep.save(user)).thenReturn(user);
		
		String password = "password";
		
		assertTrue(loginService.AuthenticateUser(user, password));
		
	}
	
	@Test
	public void testGetUserByName() {
		
		User user = new User();
		user.setId(1);
		user.setName("Dummy");
		user.setEmail("dummy@dummy.com");
		user.setPassword("password");
		
		actRep.save(user);
		
		User savedUser = actRep.findByName(user.getName());
		
		assertEquals(savedUser, user);
		
	}
	
}