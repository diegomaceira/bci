package cl.com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
	    .csrf().disable()
	    .authorizeRequests()
	      .antMatchers(HttpMethod.GET,"/login").permitAll()
	      .antMatchers(HttpMethod.GET,"/login/*").permitAll()
	      .antMatchers(HttpMethod.POST,"/sign-up").permitAll()
	      .anyRequest().authenticated();
		
		return http.build();
	}
}