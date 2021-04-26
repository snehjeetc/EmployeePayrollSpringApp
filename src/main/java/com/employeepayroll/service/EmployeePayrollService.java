package com.employeepayroll.service;

import java.util.List;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeepayroll.dto.EmployeeDTO;
import com.employeepayroll.model.Employee;
import com.employeepayroll.repository.IEmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

	@Autowired
	private IEmployeePayrollRepository employeePayrollRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Employee> getEmployee() {
		return employeePayrollRepo.findAll();
	}

	@Override
	public Employee postEmployee(EmployeeDTO employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		return employeePayrollRepo.save(employee);
	}

	@Override
	public Employee putEmployee(int id, EmployeeDTO employeeDto) {
		Employee employee = employeePayrollRepo.findById(id).get();
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(employeeDto, employee);
		return employeePayrollRepo.save(employee);
	}

	@Override
	public Employee deleteEmployee(int id) {
		Employee employee = this.getEmployee(id);
		employeePayrollRepo.deleteById(id);
		return employee;
	}

	@Override
	public Employee getEmployee(int id) {
		return employeePayrollRepo.findById(id).get();
	}

}
