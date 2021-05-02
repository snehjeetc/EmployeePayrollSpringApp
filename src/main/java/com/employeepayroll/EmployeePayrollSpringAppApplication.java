	package com.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//locolhost:8080/swagger-ui.html
@EnableSwagger2
@SpringBootApplication
@Slf4j
public class EmployeePayrollSpringAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(EmployeePayrollSpringAppApplication.class, args);
		log.info("Employee payroll app started in {} Environment", 
				context.getEnvironment().getProperty("environment"));
	}

}
