package cl.com.service;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.com.model.User;
import cl.com.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest{
	
	@Mock	
	UserRepository userRepository;
	
	@InjectMocks 
	UserService userService;

	@BeforeEach
	public void beforeClass() {
	}
	
	
	@Test
	void testGetAllUser() {
		//fail("Not yet implemented");

		//when(userRepository.findAll()).thenReturn(null);
		//System.out.println("getall:" + userService.getAllUser());
		//assertEquals("c", "c");
	}

	@Test
	void testGetUserById() {
		//fail("Not yet implemented");
	}

	@Test
	void testSave() {
		//fail("Not yet implemented");
		
		List<cl.com.model.Telephone> telephones = new ArrayList<cl.com.model.Telephone>();
		
		User user = new User("diego","asd","123",telephones);
			
		//when(userService.save(user)).thenReturn((ResponseEntity<?>) ResponseEntity.ok(HttpStatus.OK));
		
		//System.out.println("saved:" + userService.save(user));
		//assertEquals("c", "c");
	}

}
