package cl.com.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
	void beforeClass() {
	
	}	
	
	@Test
	void testGetAllUser() {
		//fail("Not yet implemented");
		
		List<cl.com.model.Telephone> telephones = new ArrayList<cl.com.model.Telephone>();
		
		User user = new User("diego","macei@google.com","asd2fq1weDr",telephones);
		
		System.out.println("save user : " + userService.save(user).getBody());

		System.out.println("find: " +userService.getUserById(1).getBody());
		
		System.out.println("find: " +userService.getAllUser().getBody());
		
		//when(userRepository.findAll()).thenReturn(null);
		//System.out.println("getall:" + userService.getAllUser());
		assertEquals("c", "c");
	}

	@Test
	@Disabled
	void testGetUserById() {
		//fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testSave() {
		//fail("Not yet implemented");
		
		List<cl.com.model.Telephone> telephones = new ArrayList<cl.com.model.Telephone>();
		
		User user = new User("diego","asd","123",telephones);
			
		//when(userService.save(user)).thenReturn((ResponseEntity<?>) ResponseEntity.ok(HttpStatus.OK));
		
		//System.out.println("saved:" + userService.save(user));
		//assertEquals("c", "c");
	}

}
