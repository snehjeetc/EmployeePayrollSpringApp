package com.employeepayroll.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EmployeeDTO {
	@NotEmpty(message = "Name must not remain empty")
	@Pattern(regexp = "[A-Z][a-z]{2,}", message = "Required valid name")
	private String name;
	@NotEmpty(message = "Email must not be empty")
	@Email(message = "Enter valid email")
	private String email;
	@NotEmpty(message = "Phone number must not be empty")
	@Pattern(regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\ -]\\s*)?|[0]?)?[789]\\d{9}|(\\d[ -]?){10}\\d$", 
			message = "Invalid Phone number")
	private String phoneNumber;
	@NotEmpty(message = "Salary field must not be empty")
	@Pattern(regexp = "[0-9]*[1-9][0-9]*", message = "Invalid salary")
	private String salary;
	@NotEmpty(message = "Gender must not be empty")
	@Pattern(regexp = "M|F", message = "Invalid gender")
	private String gender;
}
