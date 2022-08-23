package cl.com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.com.model.User;
import cl.com.repository.UserRepository;
import cl.com.security.JwtTokenUtil;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest{
	
	@Mock	
	UserRepository userRepository;
	
	@Mock	
	JwtTokenUtil jwtTokenUtil;
	
	@InjectMocks 
	UserService userService;

	@BeforeEach
	void beforeClass() {
	
	}	

	@Test
	@Disabled
	void testGetUserById() {
		//fail("Not yet implemented");
	}

	@Test
	void testSave() {
		
		//given
		List<cl.com.model.Telephone> telephones = new ArrayList<cl.com.model.Telephone>();
		
		User user = new User("diego","macei@google.com","asd2fq1weDr",telephones);
			
		//when
		userService.save(user);
		
		//then
		ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
		
		verify(userRepository).save(userArgumentCaptor.capture());
		
		User capturedUser = userArgumentCaptor.getValue();
	
		assertThat(capturedUser).isEqualTo(user);
	}
		
	@Test
	@Disabled
	void testGetAllUser() {
		//fail("Not yet implemented");	

		System.out.println("find: " +userService.getUserById(1).getBody());
		
		System.out.println("find: " +userService.getAllUser().getBody());
		
		//when(userRepository.findAll()).thenReturn(null);
		//System.out.println("getall:" + userService.getAllUser());
		assertEquals("c", "c");
	}


}
