package cl.bci.controller;

import cl.bci.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.bci.service.UserService;

import java.util.List;

@RestController
public class UserController {
  
	@Autowired
	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(path= "/login" , consumes = "application/json", produces = "application/json" )
	private ResponseEntity<List<UserDTO>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUser());
	}

	@GetMapping(path="/login/{id}", consumes = "application/json", produces = "application/json" )
	private ResponseEntity<UserDTO> getUser(@PathVariable("id") int id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@PostMapping(path="/sign-up", consumes = "application/json", produces = "application/json" )
	private ResponseEntity saveUser(@RequestBody UserDTO user) {

		try{
			return ResponseEntity.ok(userService.save(user));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}
}