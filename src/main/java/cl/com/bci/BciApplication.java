package cl.com.bci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="cl.com.*")
public class BciApplication {

	public static void main(String[] args) {
		SpringApplication.run(BciApplication.class, args);
	}

}
