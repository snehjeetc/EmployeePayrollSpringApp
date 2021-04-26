package com.employeepayroll.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
	private String name;
	private String email;
	private long phoneNumber;
	private int salary;
}
