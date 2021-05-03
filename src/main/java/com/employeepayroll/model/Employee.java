package com.employeepayroll.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model for employee payroll data
 * which is stored in the database
 * @author snehjeetc12
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employee_payroll")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Integer id;
	private String name;
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	private long salary;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	private String gender;
	
	/**
	 * Creates employee_department table with foreign key id of department table
	 * and primary key employee_id from employee_payroll table
	 */
	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> departments;
	private String note;
	private String profilePic;
}
