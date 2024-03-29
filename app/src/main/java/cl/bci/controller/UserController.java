package cl.bci.controller;

import cl.bci.dto.UserDTO;
import cl.bci.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(path = "/login", consumes = "application/json", produces = "application/json")
    private ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userServiceImpl.getAllUser());
    }

    @GetMapping(path = "/login/{id}", consumes = "application/json", produces = "application/json")
    private ResponseEntity<UserDTO> getUser(@PathVariable("id") int id) {
        return ResponseEntity.ok(userServiceImpl.getUserById(id));
    }

    @PostMapping(path = "/sign-up", consumes = "application/json", produces = "application/json")
    private ResponseEntity saveUser(@RequestBody UserDTO user) {

        try {
            return ResponseEntity.ok(userServiceImpl.save(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
