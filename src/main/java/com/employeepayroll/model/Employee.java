package com.employeepayroll.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.employeepayroll.dto.EmployeeDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String phoneNumber;
	private String salary;
	private LocalDate joinDate;
	private String gender;
	
	public Employee() {
		this.joinDate = LocalDate.now();
	}
	
	public Employee(EmployeeDTO employeeDto) {
		this.name = employeeDto.getName();
		this.email = employeeDto.getEmail();
		this.phoneNumber = employeeDto.getPhoneNumber();
		this.salary = employeeDto.getSalary();
		this.gender = employeeDto.getGender();
		this.joinDate = LocalDate.now();
	}
}
