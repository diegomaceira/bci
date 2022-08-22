package cl.com.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	
	public ResponseEntity<?> getAllUser() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(student -> users.add(student));
		return ResponseEntity.ok(users);
	}
  
	public ResponseEntity<?> getUserById(int id) {		
		return ResponseEntity.ok(userRepository.findById(id));
	}

	public ResponseEntity<?> save(User user) {
				
		List<ErrorDetail> errorDetail = new ArrayList<ErrorDetail>();
		
		//Exist user on db?
		if(userRepository.findByEmail(user.getEmail())!=null)errorDetail.add(new ErrorDetail(null, 403, "Ya existe un usuario con ese email"));
		
		//Email validation
		if(!Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$").matcher(user.getEmail()).matches()) errorDetail.add(new ErrorDetail(null, 403, "Formato de email invalido"));			
		
		//Password validation 
		//if(!Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,12}$").matcher(user.getPassword()).matches()) errorDetail.add(new ErrorDetail(null, 403, "Formato de password invalido"));		
		if(!Pattern.compile("^(?=.*[a-z])(?=.*[A-Z]{1})(?=.*\\d)[A-Za-z\\d]{8,12}$").matcher(user.getPassword()).matches()) errorDetail.add(new ErrorDetail(null, 403, "Formato de password invalido"));
							
		if(errorDetail.size()>0)return ResponseEntity.ok(new cl.com.model.Error(errorDetail));
		
	    String formatedDate = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a").format(new Date());
      		
		user.setCreated(formatedDate);
		user.setLastLogin(formatedDate);		
		user.setIsActive(true);
		user.setToken(jwtTokenUtil.generateToken(user.getName()));
		
		userRepository.save(user);
		
		return ResponseEntity.ok(HttpStatus.OK);
	}
	/*
	void validate(String password) {
	    //String minMaxLength = "/^[\s\S]{8,32}$/";
	    String upper = "/[A-Z]/";
	    String lower = "/[a-z]/";
        String number = "/[0-9]/";
	    String special = "/[^A-Za-z0-9]/";
	    int count = 0;

	    if (minMaxLength.test(password)) {
	        // Only need 3 out of 4 of these to match
	        if (upper.test(password)) count++;
	        if (lower.test(password)) count++;
	        if (number.test(password)) count++;
	        if (special.test(password)) count++;
	    }

	    return count >= 3;
	}
	*/

}
