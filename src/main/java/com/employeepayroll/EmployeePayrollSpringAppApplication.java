	package com.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//locolhost:8080/swagger-ui.html
@EnableSwagger2
@SpringBootApplication
public class EmployeePayrollSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollSpringAppApplication.class, args);
	}

}
