package cl.com.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.com.model.ErrorDetail;
import cl.com.model.User;
import cl.com.repository.UserRepository;
import cl.com.security.JwtTokenUtil;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
  
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	public List<User> getAllUser() {
		List<User> students = new ArrayList<User>();
		userRepository.findAll().forEach(student -> students.add(student));
		return students;
	}
  
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	public ResponseEntity<?> saveOrUpdate(User user) {
				
		List<ErrorDetail> errorDetail = new ArrayList<ErrorDetail>();
		
		//Email validation
		if(!Pattern.compile("^(.+)@(.+)$").matcher(user.getEmail()).matches()) {
			errorDetail.add(new ErrorDetail(null, 403, "Formato de email invalido"));
			return ResponseEntity.ok(new cl.com.model.Error(errorDetail));
		}
		
		System.out.println(" token: " + jwtTokenUtil.generateToken(user.getName()));
						
		user.setCreated(new Timestamp(System.currentTimeMillis()));
		user.setLastLogin(new Timestamp(System.currentTimeMillis()));		
		user.setIsActive(true);
		
		userRepository.save(user);
		
		return ResponseEntity.ok(HttpStatus.OK);
	}
	

}