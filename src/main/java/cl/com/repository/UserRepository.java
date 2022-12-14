package cl.com.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.com.model.User;  

@Repository
public interface UserRepository extends CrudRepository<User, Integer>  
{  
	
	User findByEmail (String email);
	
	List<User> findAll();
	
	User findById(int id);
	
}  
