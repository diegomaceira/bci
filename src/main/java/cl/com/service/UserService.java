package cl.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.com.model.User;
import cl.com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
  
	public List<User> getAllUser() {
		List<User> students = new ArrayList<User>();
		userRepository.findAll().forEach(student -> students.add(student));
		return students;
	}
  
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}

	public void delete(int id) {
		userRepository.deleteById(id);
	}
	
}