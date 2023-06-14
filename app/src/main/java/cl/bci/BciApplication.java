package cl.bci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"cl.com.*"})
@EnableJpaRepositories("cl.com.repository")
@EntityScan("cl.com.model")       
public class BciApplication {

	public static void main(String[] args) {
		SpringApplication.run(BciApplication.class, args);
	}

}
