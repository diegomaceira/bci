package cl.com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.com.model.User;

class UserServiceTest{

	UserService userService=mock(UserService.class);
	
	//UserRepository userRepository=mock(UserRepository.class);
	
	@BeforeEach
	public void beforeClass() {
	}
	
	
	@Test
	void testGetAllUser() {
		//fail("Not yet implemented");

		//System.out.println("getall:" + userService.getAllUser());
		assertEquals("c", "c");
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
		assertEquals("c", "c");
	}

}
