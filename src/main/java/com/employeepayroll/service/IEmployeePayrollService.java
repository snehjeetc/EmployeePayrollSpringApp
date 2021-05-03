package com.employeepayroll.service;

import java.util.List;

import com.employeepayroll.dto.EmployeeDTO;
import com.employeepayroll.model.Employee;

public interface IEmployeePayrollService {
	List<Employee> getEmployee();
	Employee getEmployee(int id);
	List<Employee> getEmployeeByDepartment(String department);
	Employee postEmployee(EmployeeDTO employeeDto);
	Employee putEmployee(int id, EmployeeDTO employeeDto);
	Employee deleteEmployee(int id);	
}
