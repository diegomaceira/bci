package cl.com.bci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.com.controller.UserController;
import spock.lang.Specification;

@SpringBootTest
class BciApplicationTests extends Specification {

    @Autowired (required = false)
    private UserController userController;

    
}
