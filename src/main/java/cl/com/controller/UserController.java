package cl.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.com.model.User;
import cl.com.service.UserService;

@RestController
public class UserController {
  
	@Autowired
	UserService userService;

	@GetMapping(path= "/login" , consumes = "application/json", produces = "application/json" )
	private List<User> getAllUsers() {
		return userService.getAllUser();
	}

	@GetMapping(path="/login/{id}", consumes = "application/json", produces = "application/json" )
	private User getUser(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}

	@PostMapping(path="/sign-up", consumes = "application/json", produces = "application/json" )
	private ResponseEntity<?> saveUser(@RequestBody User student) {		
		return userService.saveOrUpdate(student);
	}
}
