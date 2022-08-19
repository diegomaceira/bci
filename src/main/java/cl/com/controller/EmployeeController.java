package cl.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.com.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/employ")
	Employee empleado() {
		Employee employee = new Employee("test", "123");
		return employee;
	}
		
}
