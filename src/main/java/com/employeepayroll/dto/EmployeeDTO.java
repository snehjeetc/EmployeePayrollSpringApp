package com.employeepayroll.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

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
	
	@Min(value = 500, message = "Min wage should be more than 500")
	private long salary;
	
	@NotEmpty(message = "Gender must not be empty")
	@Pattern(regexp = "male|female", message = "Gender must be male | female")
	private String gender;
	
	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull
	@PastOrPresent(message = "startDate should not be future date")
	private LocalDate startDate;
	
	@NotBlank(message = "note should not be blank")
	private String note;
	
	@NotBlank(message = "profilePic should not be blank")
	private String profilePic;

	@NotNull
	private List<String> departments;
	
}
