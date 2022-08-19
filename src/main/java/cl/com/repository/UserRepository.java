package cl.com.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.com.model.User;  

@Repository
public interface UserRepository extends CrudRepository<User, Integer>  
{  
}  
