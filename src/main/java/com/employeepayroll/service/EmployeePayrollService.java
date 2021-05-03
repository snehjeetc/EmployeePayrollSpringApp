package com.employeepayroll.service;

import java.util.List;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeepayroll.dto.EmployeeDTO;
import com.employeepayroll.exception.EmployeePayrollException;
import com.employeepayroll.exception.EmployeePayrollException.EXCEPTION_TYPE;
import com.employeepayroll.model.Employee;
import com.employeepayroll.repository.IEmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Service layer to perform operations after getting from REST controller
 * @author snehjeetc12
 */
@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

	@Autowired
	private IEmployeePayrollRepository employeePayrollRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Fetches all the employee payroll data in the database
	 * @return List<Employee>
	 */
	@Override
	public List<Employee> getEmployee() {
		return employeePayrollRepo.findAll();
	}
	
	/**
	 * Returns the employee who has the required id 
	 * @throws EmployeePayrollException
	 * @param id
	 * @return Employee
	 */
	@Override
	public Employee getEmployee(int id) {
		return employeePayrollRepo.findById(id)
								  .orElseThrow(()-> 
								  new EmployeePayrollException("Employee doesn't exist", 
								      EXCEPTION_TYPE.EMPLOYEE_NOT_FOUND));
	}

	/**
	 * Fetches List of Employee to the caller having same given 
	 * department
	 * @param department
	 * @return List<Employee>
	 */
	@Override
	public List<Employee> getEmployeeByDepartment(String department){
		return employeePayrollRepo.findEmployeeByDepartment(department);
	}

	/**
	 * Creates a new Employee object from the EmployeeDTO object
	 * and adds it to the database
	 * @Param EmployeeDTO
	 * @return Employee
	 */
	@Override
	public Employee postEmployee(EmployeeDTO employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		log.debug("Employee data: " + employee.toString());
		return employeePayrollRepo.save(employee);
	}

	/**
	 * Updates the Employee payroll data of given id with EmployeeDTO object
	 * @param id, EmployeeDTO
	 * @return Employee
	 */
	@Override
	public Employee putEmployee(int id, EmployeeDTO employeeDto) {
		Employee employee = employeePayrollRepo.findById(id).get();
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(employeeDto, employee);
		return employeePayrollRepo.save(employee);
	}

	/**
	 * Delete the employee payroll data from the database of given id
	 * @param id
	 * @return Employee
	 */
	@Override
	public Employee deleteEmployee(int id) {
		Employee employee = this.getEmployee(id);
		employeePayrollRepo.deleteById(id);
		return employee;
	}
}
