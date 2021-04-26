package com.employeepayroll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.employeepayroll.dto.EmployeeDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private long phoneNumber;
	private int salary;
	
	public Employee(EmployeeDTO employeeDto) {
		this.name = employeeDto.getName();
		this.email = employeeDto.getEmail();
		this.phoneNumber = employeeDto.getPhoneNumber();
		this.salary = employeeDto.getSalary();
	}
}
